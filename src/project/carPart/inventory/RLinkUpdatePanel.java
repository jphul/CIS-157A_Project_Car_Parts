package project.carPart.inventory;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class RLinkUpdatePanel extends JPanel {

    static ArrayList<String> arsNum = new ArrayList<String>();
    static ArrayList<String> behNum = new ArrayList<String>();
    static ArrayList<String> danNum = new ArrayList<String>();
    static ArrayList<String> modNum = new ArrayList<String>();

    static JLabel warning = new JLabel("Enter an RLink Number then click OK");
    static JLabel pre = new JLabel();
    static JTextField inputRLNum = new JTextField(5);

    static JTextField ars1 = new JTextField("", 4);
    static JTextField ars2 = new JTextField("", 4);
    static JTextField ars3 = new JTextField("", 4);
    static JTextField ars4 = new JTextField("", 4);
    static JTextField beh1 = new JTextField("", 4);
    static JTextField beh2 = new JTextField("", 4);
    static JTextField beh3 = new JTextField("", 4);
    static JTextField beh4 = new JTextField("", 4);
    static JTextField dan1 = new JTextField("", 4);
    static JTextField dan2 = new JTextField("", 4);
    static JTextField dan3 = new JTextField("", 4);
    static JTextField dan4 = new JTextField("", 4);
    static JTextField mod1 = new JTextField("", 4);
    static JTextField mod2 = new JTextField("", 4);
    static JTextField mod3 = new JTextField("", 4);
    static JTextField mod4 = new JTextField("", 4);

    static DBConnection dbConn = new DBConnection();
    final Connection con = dbConn.getDBConnection();

    static int rlNum;

    public RLinkUpdatePanel() {

        rlNum = RLinkOperations.getTotalRLink(con);
        pre.setText("Enter RLink Number: ");
        // ==== Instruction Panel on Top ====
        JPanel topPanel = new JPanel();

        // topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.add(pre);
        topPanel.add(inputRLNum);
        inputRLNum.setText("" + rlNum);

        JButton okBut = new JButton("OK");
        topPanel.add(okBut);
        okBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String s = inputRLNum.getText();
                if (RLinkOperations.getRLink(con, s))// update
                // arsNum,behNum,danNum,modNum
                {
                    ars1.setText(arsNum.get(0));
                    ars2.setText(arsNum.get(1));
                    ars3.setText(arsNum.get(2));
                    ars4.setText(arsNum.get(3));

                    beh1.setText(behNum.get(0));
                    beh2.setText(behNum.get(1));
                    beh3.setText(behNum.get(2));
                    beh4.setText(behNum.get(3));

                    dan1.setText(danNum.get(0));
                    dan2.setText(danNum.get(1));
                    dan3.setText(danNum.get(2));
                    dan4.setText(danNum.get(3));

                    mod1.setText(modNum.get(0));
                    mod2.setText(modNum.get(1));
                    mod3.setText(modNum.get(2));
                    mod4.setText(modNum.get(3));
                }
            }
        });

        // =====end top panel ================

        // ==== Input Panel in Mid ====
        JPanel midPanel = new JPanel();
        JPanel ars = new JPanel();
        JPanel beh = new JPanel();
        JPanel dan = new JPanel();
        JPanel mod = new JPanel();

        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.X_AXIS));
        midPanel.add(ars);
        midPanel.add(mod);
        midPanel.add(beh);
        midPanel.add(dan);

        // === ARS List ===
        JLabel ars1L = new JLabel("ARS1: ");
        JLabel ars2L = new JLabel("ARS2: ");
        JLabel ars3L = new JLabel("ARS3: ");
        JLabel ars4L = new JLabel("ARS4: ");

        ars.setLayout(new BoxLayout(ars, BoxLayout.Y_AXIS));
        ars.add(ars1L);
        ars.add(ars1);
        ars.add(ars2L);
        ars.add(ars2);
        ars.add(ars3L);
        ars.add(ars3);
        ars.add(ars4L);
        ars.add(ars4);

        // === BEH List ===
        JLabel beh1L = new JLabel("BEH1: ");
        JLabel beh2L = new JLabel("BEH2: ");
        JLabel beh3L = new JLabel("BEH3: ");
        JLabel beh4L = new JLabel("BEH4: ");

        beh.setLayout(new BoxLayout(beh, BoxLayout.Y_AXIS));
        beh.add(beh1L);
        beh.add(beh1);
        beh.add(beh2L);
        beh.add(beh2);
        beh.add(beh3L);
        beh.add(beh3);
        beh.add(beh4L);
        beh.add(beh4);

        // === DAN List ===
        JLabel dan1L = new JLabel("DAN1: ");
        JLabel dan2L = new JLabel("DAN2: ");
        JLabel dan3L = new JLabel("DAN3: ");
        JLabel dan4L = new JLabel("DAN4: ");

        dan.setLayout(new BoxLayout(dan, BoxLayout.Y_AXIS));
        dan.add(dan1L);
        dan.add(dan1);
        dan.add(dan2L);
        dan.add(dan2);
        dan.add(dan3L);
        dan.add(dan3);
        dan.add(dan4L);
        dan.add(dan4);

        // === MOD List ===
        JLabel mod1L = new JLabel("MOD1: ");
        JLabel mod2L = new JLabel("MOD2: ");
        JLabel mod3L = new JLabel("MOD3: ");
        JLabel mod4L = new JLabel("MOD4: ");

        mod.setLayout(new BoxLayout(mod, BoxLayout.Y_AXIS));
        mod.add(mod1L);
        mod.add(mod1);
        mod.add(mod2L);
        mod.add(mod2);
        mod.add(mod3L);
        mod.add(mod3);
        mod.add(mod4L);
        mod.add(mod4);
        // =====end mid panel===============

        // ==== Bottom Panel: buttons + warnings =========
        JPanel butPanel = new JPanel();
        JButton updateBut = new JButton("Update");
        updateBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                arsNum.removeAll(arsNum);
                arsNum.add(ars1.getText());
                arsNum.add(ars2.getText());
                arsNum.add(ars3.getText());
                arsNum.add(ars4.getText());

                behNum.removeAll(behNum);
                behNum.add(beh1.getText());
                behNum.add(beh2.getText());
                behNum.add(beh3.getText());
                behNum.add(beh4.getText());

                danNum.removeAll(danNum);
                danNum.add(dan1.getText());
                danNum.add(dan2.getText());
                danNum.add(dan3.getText());
                danNum.add(dan4.getText());

                modNum.removeAll(modNum);
                modNum.add(mod1.getText());
                modNum.add(mod2.getText());
                modNum.add(mod3.getText());
                modNum.add(mod4.getText());

                String rl = inputRLNum.getText();
                warning.setText(RLinkOperations.updateRLink(con, rl, arsNum,
                        behNum, danNum, modNum));

            }
        });
        JButton cancelBut = new JButton("Cancel");
        cancelBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RLinkPanel.frameUpdate.dispose();
            }
        });

        JButton resetBut = new JButton("Reset");
        resetBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                warning.setText("Enter RLink Number then click OK");
                reset();
            }
        });
        butPanel.add(updateBut);
        butPanel.add(resetBut);
        butPanel.add(cancelBut);
        butPanel.add(warning);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.CENTER);
        add(butPanel, BorderLayout.SOUTH);
    }

    public void reset() {
        rlNum = RLinkOperations.getTotalRLink(con);
        ars1.setText("");
        ars2.setText("");
        ars3.setText("");
        ars4.setText("");
        beh1.setText("");
        beh2.setText("");
        beh3.setText("");
        beh4.setText("");
        dan1.setText("");
        dan2.setText("");
        dan3.setText("");
        dan4.setText("");
        mod1.setText("");
        mod2.setText("");
        mod3.setText("");
        mod4.setText("");
    }
}
