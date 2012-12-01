package project.carPart.inventory;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.util.Collections;


@SuppressWarnings("serial")
class RetrievePanel extends JPanel {
    public static String carMakers[] = { "BUICK", "CADILLAC", "CHEVROLET",
            "CHRYSLER", "FORD LIGHT TRUCK AND VAN", "FORD",
            "CHEVROLET & GMC TRUCK & VAN", "INTERNATIONAL TRUCK (I.H.C.)",
            "ISUZU", "LINCOLN", "MAZDA", "OLDSMOBILE", "PORSCHE", "RENAULT",
            "SAAB", "SUBARU", "TOYOTA", "UPS", "VOLKSWAGEN" };
    public static String carTable[] = { "APLBUK", "APLCAD", "APLCHE", "APLCRY",
            "APLFDT", "APLFOR", "APLGMC", "APLINT", "APLISU", "APLLIN",
            "APLMZD", "APLOLD", "APLPOR", "APLREN", "APLSAB", "APLSUB",
            "APLTOY", "APLUPS", "APLVOL" };
    DBConnection dbConn = new DBConnection();
    final Retrieve dbo = new Retrieve();
    final Connection con = dbConn.getDBConnection();

    JComboBox cmbCarMakers;
    static JComboBox cmbCarModel;
    static JComboBox cmbCarYear;
    static JComboBox cmbRlink;
    static JComboBox cmbAMB;
    JButton btnReset = new JButton("Reset");
    JButton btnClose = new JButton("Close");
    JButton btnRetrieve = new JButton("Retrieve");
    static JTextArea txtDisplay = new JTextArea(10, 50);
    static JFrame frame = new JFrame();

    public RetrievePanel() {
        cmbCarMakers = new JComboBox();
        for (int i = 0; i < carMakers.length; i++) {
            cmbCarMakers.addItem(carMakers[i]);
        }

        setLayout(new BorderLayout());

        JPanel makerPanel = new JPanel();
        makerPanel.setLayout(new GridLayout(6, 2));
        makerPanel.add(new JLabel("Select Car Marker:"));
        makerPanel.add(cmbCarMakers);

        cmbCarMakers.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                int carIndex = cmbCarMakers.getSelectedIndex();
                ArrayList<String> modelList = Retrieve.getInfo(con, "model",
                        carTable[carIndex], false);
                int t = cmbCarModel.getItemCount();
                System.out.println(t);
                for (int i = 0; i < modelList.size(); i++) {
                    cmbCarModel.addItem(modelList.get(i));
                }
                cmbCarModel.setVisible(true);
                cmbCarYear.setVisible(true);
                cmbRlink.setVisible(true);
                cmbAMB.setVisible(true);
                txtDisplay.setVisible(true);
            }
        });

        cmbCarModel = new JComboBox();
        makerPanel.add(new JLabel("Select Car Model:"));
        makerPanel.add(cmbCarModel);
        cmbCarModel.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                ArrayList<String> yearList = Retrieve.getInfo(con,
                        (String) cmbCarModel.getSelectedItem(),
                        carTable[cmbCarMakers.getSelectedIndex()], true);
                for (int i = 0; i < yearList.size(); i++) {
                    cmbCarYear.addItem(yearList.get(i));
                }
            }
        });

        cmbCarYear = new JComboBox();
        makerPanel.add(new JLabel("Select Car Year: "));
        makerPanel.add(cmbCarYear);
        cmbCarYear.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                String model = (String) cmbCarModel.getSelectedItem();
                String year = (String) cmbCarYear.getSelectedItem();
                int carIndex = cmbCarMakers.getSelectedIndex();
                ArrayList<Integer> rlinks = Retrieve.getCarInfo(con, model,
                        year, carTable[carIndex], carIndex);
                ArrayList<Integer> newrl = new ArrayList<Integer>();
                if (rlinks.size() > 0) {
                    newrl = eliminateDup(rlinks);
                    for (int i = 0; i < newrl.size(); i++) {
                        {
                            cmbRlink.addItem(newrl.get(i));
                        }
                    }
                }
            }
        });

        cmbRlink = new JComboBox();
        makerPanel.add(new JLabel("Select Rlink: "));
        makerPanel.add(cmbRlink);
        cmbRlink.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                Object rl = cmbRlink.getSelectedItem();
                ArrayList<String> ambList = Retrieve.getPartInfo(con, "*", rl);
                for (int i = 0; i < ambList.size(); i++) {
                    cmbAMB.addItem(ambList.get(i));
                }
            }
        });

        cmbAMB = new JComboBox();
        makerPanel.add(new JLabel("Select ARS, MOD, or BEH: "));
        makerPanel.add(cmbAMB);
        makerPanel.add(new JLabel("More Info:"));

        JPanel displayPanel = new JPanel();
        JScrollPane a = new JScrollPane(txtDisplay);
        a.setPreferredSize(new Dimension(750, 200));
        displayPanel.add(a);

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnRetrieve);
        btnPanel.add(new JLabel("  "));
        btnPanel.add(btnReset);
        btnPanel.add(new JLabel("  "));
        btnPanel.add(btnClose);

        btnRetrieve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Object linkNum = cmbRlink.getSelectedItem();
                String ambp = (String) cmbAMB.getSelectedItem();
                if (ambp != null) {
                    Retrieve.getPartInfo3(con, ambp, linkNum);

                    if (ambp.substring(0, 1).equalsIgnoreCase("A")) {
                        Retrieve.getPartInfo2(con, "rdimars", ambp, linkNum);
                    } else if (ambp.substring(0, 1).equalsIgnoreCase("B")) {
                        Retrieve.getPartInfo2(con, "rdimbeh", ambp, linkNum);
                    } else if (ambp.substring(0, 1).equalsIgnoreCase("D")) {
                        Retrieve.getPartInfo2(con, "rdimdan", ambp, linkNum);
                    } else if (ambp.substring(0, 1).equalsIgnoreCase("M")) {
                        Retrieve.getPartInfo2(con, "rdimmod", ambp, linkNum);
                    }
                    Log.log.add("Retrieved a Part from a Car");
                }
            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cmbCarModel.removeAllItems();
                cmbCarYear.removeAllItems();
                cmbRlink.removeAllItems();
                cmbAMB.removeAllItems();

                txtDisplay.setText("");
            }
        });
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                MainMenu.frameRetrieve.dispose();
            }
        });

        add(makerPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

    }

    public static ArrayList<Integer> eliminateDup(ArrayList<Integer> rl) {
        Collections.sort(rl);
        ArrayList<Integer> nrl = new ArrayList<Integer>();
        nrl.add(rl.get(0));
        for (int i = 1; i < rl.size(); i++) {
            if (!nrl.contains(rl.get(i))) {
                nrl.add(rl.get(i));
            }
        }
        return nrl;
    }
}