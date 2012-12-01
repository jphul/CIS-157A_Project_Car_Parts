package project.carPart.inventory;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.*;

public class PartDelPanel extends JPanel {

    static JComboBox manufacturer = new JComboBox();

    static JTextField pNumBox = new JTextField(6);
    static JLabel warning = new JLabel(
            "Choose a Manufacturer and enter a Part Number to DELETE");

    static DBConnection dbConn = new DBConnection();
    final Connection con = dbConn.getDBConnection();

    public PartDelPanel() {
        JPanel infoPanel = new JPanel();
        manufacturer.removeAllItems();
        manufacturer.addItem("ARS");
        manufacturer.addItem("MOD");
        manufacturer.addItem("BEH");
        manufacturer.addItem("DAN");

        infoPanel.setLayout(new GridLayout(2, 2));
        infoPanel.setPreferredSize(new Dimension(500, 100));
        infoPanel.add(new JLabel("Select a Manufacturer: "));
        infoPanel.add(manufacturer);
        infoPanel.add(new JLabel("Enter Part Number to DELETE: "));
        infoPanel.add(pNumBox);

        JPanel botPanel = new JPanel();
        JButton delBut = new JButton("Delete");
        delBut.addActionListener(new ActionListener() {
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
                PartOperations.delPart(con, m, pnum);
            }
        });

        JButton resBut = new JButton("Reset");
        resBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pNumBox.setText("");
            }
        });

        JButton cancelBut = new JButton("Cancel");
        cancelBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PartModPanel.frameDel.dispose();
            }
        });

        botPanel.add(delBut);
        botPanel.add(resBut);
        botPanel.add(cancelBut);
        botPanel.add(warning);
        add(infoPanel, BorderLayout.NORTH);
        add(botPanel, BorderLayout.SOUTH);
    }
}
