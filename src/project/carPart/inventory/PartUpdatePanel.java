package project.carPart.inventory;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.*;

public class PartUpdatePanel extends JPanel {

    static ArrayList<String> oldValues = new ArrayList<String>();
    static String oldPnum = "";

    static JComboBox manufacturer = new JComboBox();

    static JTextField pNumBox = new JTextField(6);
    static JTextField coreBox = new JTextField("NULL", 32);
    static JTextField inheadBox = new JTextField("NULL", 17);
    static JTextField outheadBox = new JTextField("NULL", 17);
    static JTextField inconBox = new JTextField("NULL", 14);
    static JTextField ouconBox = new JTextField("NULL", 14);
    static JTextField tmountBox = new JTextField("NULL", 24);
    static JTextField oilBox = new JTextField("NULL", 10);
    static JTextField priceBox = new JTextField("0", 11);
    static JTextField amountBox = new JTextField("0", 10);

    static JLabel warning = new JLabel(
            "Choose a Manufacturer and enter ALL details");

    static DBConnection dbConn = new DBConnection();
    final Connection con = dbConn.getDBConnection();

    public PartUpdatePanel() {
        JPanel infoPanel = new JPanel();
        manufacturer.removeAllItems();
        manufacturer.addItem("ARS");
        manufacturer.addItem("MOD");
        manufacturer.addItem("BEH");
        manufacturer.addItem("DAN");

        infoPanel.setLayout(new GridLayout(11, 2));
        infoPanel.setPreferredSize(new Dimension(500, 300));

        infoPanel.add(new JLabel("Select a Manufacturer: "));
        infoPanel.add(manufacturer);

        JButton numBut = new JButton("Retrieve this Part Number: ");

        infoPanel.add(numBut);
        infoPanel.add(pNumBox);
        infoPanel.add(new JLabel("Enter Core: "));
        infoPanel.add(coreBox);
        infoPanel.add(new JLabel("Enter Inhead: "));
        infoPanel.add(inheadBox);
        infoPanel.add(new JLabel("Enter Outhead: "));
        infoPanel.add(outheadBox);
        infoPanel.add(new JLabel("Enter Incon: "));
        infoPanel.add(inconBox);
        infoPanel.add(new JLabel("Enter Oucon: "));
        infoPanel.add(ouconBox);
        infoPanel.add(new JLabel("Enter Tmount: "));
        infoPanel.add(tmountBox);
        infoPanel.add(new JLabel("Enter OilCool: "));
        infoPanel.add(oilBox);
        infoPanel.add(new JLabel("Enter Price: "));
        infoPanel.add(priceBox);
        infoPanel.add(new JLabel("Enter Amount: "));
        infoPanel.add(amountBox);

        numBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // pNumBox.setEnabled(false);
                int m = 0;
                String manu = (String) manufacturer.getSelectedItem();
                if (manu.equals("ARS"))
                    m = PartOperations.mARS;
                if (manu.equals("BEH"))
                    m = PartOperations.mBEH;
                if (manu.equals("MOD"))
                    m = PartOperations.mMOD;
                if (manu.equals("DAN"))
                    m = PartOperations.mDAN;
                oldPnum = pNumBox.getText();
                if (PartOperations.getPart(con, m, oldPnum)) {
                    coreBox.setText(oldValues.get(0));
                    inheadBox.setText(oldValues.get(1));
                    outheadBox.setText(oldValues.get(2));
                    inconBox.setText(oldValues.get(3));
                    ouconBox.setText(oldValues.get(4));
                    tmountBox.setText(oldValues.get(5));
                    oilBox.setText(oldValues.get(6));
                    priceBox.setText(oldValues.get(7));
                    amountBox.setText(oldValues.get(8));
                }
            }
        });

        JPanel botPanel = new JPanel();
        JButton updateBut = new JButton("Update");
        updateBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int m = 0;
                String manu = (String) manufacturer.getSelectedItem();
                if (manu.equals("ARS"))
                    m = PartOperations.mARS;
                if (manu.equals("BEH"))
                    m = PartOperations.mBEH;
                if (manu.equals("MOD"))
                    m = PartOperations.mMOD;
                if (manu.equals("DAN"))
                    m = PartOperations.mDAN;
                String pnum = pNumBox.getText();
                ArrayList<String> al = new ArrayList<String>();
                al.add(coreBox.getText());
                al.add(inheadBox.getText());
                al.add(outheadBox.getText());
                al.add(inconBox.getText());
                al.add(ouconBox.getText());
                al.add(tmountBox.getText());
                al.add(oilBox.getText());
                al.add(priceBox.getText());
                al.add(amountBox.getText());

                PartOperations.updatePart(con, m, pnum, al);
                // pNumBox.setEnabled(true);
            }
        });

        JButton resBut = new JButton("Reset");
        resBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pNumBox.setText("");
                // pNumBox.setEnabled(true);
                coreBox.setText("NULL");
                inheadBox.setText("NULL");
                outheadBox.setText("NULL");
                inconBox.setText("NULL");
                ouconBox.setText("NULL");
                tmountBox.setText("NULL");
                oilBox.setText("NULL");
                priceBox.setText("0");
                amountBox.setText("0");
            }
        });

        JButton cancelBut = new JButton("Cancel");
        cancelBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PartModPanel.frameUpd.dispose();
            }
        });

        botPanel.add(updateBut);
        botPanel.add(resBut);
        botPanel.add(cancelBut);
        botPanel.add(warning);
        add(infoPanel, BorderLayout.NORTH);
        add(botPanel, BorderLayout.SOUTH);
    }
}
