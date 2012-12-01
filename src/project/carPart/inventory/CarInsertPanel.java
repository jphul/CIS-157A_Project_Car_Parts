package project.carPart.inventory;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;



@SuppressWarnings("serial")
class CarInsertPanel extends JPanel {
    public static String carMakers[] = { "BUICK", "CADILLAC", "CHEVROLET",
            "CHRYSLER", "FORD LIGHT TRUCK AND VAN", "FORD",
            "CHEVROLET & GMC TRUCK & VAN", "INTERNATIONAL TRUCK (I.H.C.)",
            "ISUZU", "LINCOLN", "MAZDA", "OLDSMOBILE", "PORSCHE", "RENAULT",
            "SAAB", "SUBARU", "TOYOTA", "UPS", "VOLKSWAGEN" };
    public static String carTable[] = { "APLBUK", "APLCAD", "APLCHE", "APLCRY",
            "APLFDT", "APLFOR", "APLGMC", "APLINT", "APLISU", "APLLIN",
            "APLMZD", "APLOLD", "APLPOR", "APLREN", "APLSAB", "APLSUB",
            "APLTOY", "APLUPS", "APLVOL" };

    static ArrayList<String> desc = new ArrayList<String>();
    static ArrayList<String> LTR = new ArrayList<String>();
    static ArrayList<String> Eng = new ArrayList<String>();
    static ArrayList<String> CID = new ArrayList<String>();
    static ArrayList<String> Rlink = new ArrayList<String>();

    static DBConnection dbConn = new DBConnection();
    final CarInsert dbo = new CarInsert();
    final Connection con = dbConn.getDBConnection();

    JComboBox cmbCarMakers;
    static JComboBox cmbCarModel;
    static JComboBox cmbCarYear;
    static JComboBox cmbDesc;
    static JComboBox cmbEng;
    static JComboBox cmbCID;
    static JComboBox cmbRlink;
    static JComboBox cmbLTR;
    JButton btnReset = new JButton("Reset");
    JButton btnClose = new JButton("Cancel");
    JButton btnInsert = new JButton("Insert");
    static JTextArea txtDisplay = new JTextArea(
            "Please choose Model you want to add new Year of."
                    + "\nPlease follow the instruction carefully."
                    + "\nP.S.:You cannot add new Model or Maker.", 10, 50);

    public CarInsertPanel() {
        cmbCarMakers = new JComboBox();

        for (int i = 0; i < carMakers.length; i++) {
            cmbCarMakers.addItem(carMakers[i]);
        }

        setLayout(new BorderLayout());
        JPanel makerPanel = new JPanel();
        makerPanel.setLayout(new GridLayout(8, 2));
        makerPanel.add(new JLabel("Select Car Marker:"));
        makerPanel.add(cmbCarMakers);

        cmbCarMakers.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {

                int carIndex = cmbCarMakers.getSelectedIndex();
                ArrayList<String> modelList = CarInsert.getInfo(con, "model",
                        carTable[carIndex], false);
                int t = cmbCarModel.getItemCount();
                System.out.println(t);
                // cmbCarModel.addItem("");
                for (int i = 0; i < modelList.size(); i++) {
                    cmbCarModel.addItem(modelList.get(i));
                }

                txtDisplay.setVisible(true);

            }
        });

        cmbCarModel = new JComboBox();
        makerPanel.add(new JLabel("Select Car Model:"));
        makerPanel.add(cmbCarModel);

        cmbCarModel.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {

                ArrayList<String> yearList = CarInsert.getInfo(con,
                        (String) cmbCarModel.getSelectedItem(),
                        carTable[cmbCarMakers.getSelectedIndex()], true);

                for (int i = 0; i < yearList.size(); i++) {
                    cmbCarYear.addItem(yearList.get(i));
                }

            }
        });

        cmbCarYear = new JComboBox();
        cmbCarYear.setEditable(true);
        // JPanel yearPanel = new JPanel();
        makerPanel.add(new JLabel("Select/Enter Car Year (2 Digit numbers): "));
        // yearPanel.add(displayYear);
        makerPanel.add(cmbCarYear);

        cmbCarYear.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie) {

                String model = (String) cmbCarModel.getSelectedItem();
                String year = (String) cmbCarYear.getSelectedItem();
                int carIndex = cmbCarMakers.getSelectedIndex();

                CarInsert.getCarInfo(con, model, year, carTable[carIndex],
                        carIndex);

                desc = CarInsert.getDesc(con, model, year, carTable[carIndex]);
                System.out.println(desc);
                cmbDesc.removeAllItems();
                cmbDesc.addItem("");
                for (int i = 0; i < desc.size(); i++)
                    cmbDesc.addItem(desc.get(i));

            }
        });

        cmbDesc = new JComboBox();
        cmbDesc.setEditable(true);
        makerPanel.add(new JLabel("Enter a Description: "));
        makerPanel.add(cmbDesc);

        cmbDesc.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie) {

                String model = (String) cmbCarModel.getSelectedItem();
                String year = (String) cmbCarYear.getSelectedItem();
                int carIndex = cmbCarMakers.getSelectedIndex();
                String desc = (String) cmbDesc.getSelectedItem();

                LTR = CarInsert.getLTR(con, model, year, carTable[carIndex],
                        desc);
                System.out.println(desc);
                cmbLTR.removeAllItems();

                for (String s : LTR)
                    cmbLTR.addItem(s);

            }
        });

        cmbLTR = new JComboBox();
        cmbLTR.setEditable(true);
        makerPanel.add(new JLabel("Enter Litres (Max 4 Characters): "));
        makerPanel.add(cmbLTR);

        cmbLTR.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie) {

                String model = (String) cmbCarModel.getSelectedItem();
                String year = (String) cmbCarYear.getSelectedItem();
                int carIndex = cmbCarMakers.getSelectedIndex();
                String desc = (String) cmbDesc.getSelectedItem();
                String ltr = (String) cmbLTR.getSelectedItem();

                Eng = CarInsert.getEng(con, model, year, carTable[carIndex],
                        desc, ltr);
                System.out.println(desc);
                cmbEng.removeAllItems();

                for (String s : Eng)
                    cmbEng.addItem(s);

            }
        });

        cmbEng = new JComboBox();
        cmbEng.setEditable(true);
        makerPanel.add(new JLabel("Enter Engine (Max 3 Characters): "));
        makerPanel.add(cmbEng);

        cmbEng.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie) {

                String model = (String) cmbCarModel.getSelectedItem();
                String year = (String) cmbCarYear.getSelectedItem();
                int carIndex = cmbCarMakers.getSelectedIndex();
                String desc = (String) cmbDesc.getSelectedItem();
                String ltr = (String) cmbLTR.getSelectedItem();
                String eng = (String) cmbEng.getSelectedItem();

                CID = CarInsert.getCID(con, model, year, carTable[carIndex],
                        desc, ltr, eng);
                System.out.println(desc);
                cmbCID.removeAllItems();

                for (String s : CID)
                    cmbCID.addItem(s);

            }
        });

        cmbCID = new JComboBox();
        cmbCID.setEditable(true);
        // JPanel CIDPanel = new JPanel();
        makerPanel.add(new JLabel("Enter CID (Max 6 Characters): "));
        makerPanel.add(cmbCID);

        cmbCID.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie) {

                String model = (String) cmbCarModel.getSelectedItem();
                String year = (String) cmbCarYear.getSelectedItem();
                int carIndex = cmbCarMakers.getSelectedIndex();
                String desc = (String) cmbDesc.getSelectedItem();
                String ltr = (String) cmbLTR.getSelectedItem();
                String eng = (String) cmbEng.getSelectedItem();
                String cid = (String) cmbCID.getSelectedItem();

                Rlink = CarInsert.getRlink(con, model, year,
                        carTable[carIndex], desc, ltr, eng, cid);
                System.out.println(desc);
                cmbRlink.removeAllItems();

                for (String s : Rlink)
                    cmbRlink.addItem(s);

            }
        });

        cmbRlink = new JComboBox();
        cmbRlink.setEditable(true);
        // JPanel rlinkPanel = new JPanel();
        makerPanel.add(new JLabel("Enter Rlink(4 Digit Number):"));
        makerPanel.add(cmbRlink);

        JPanel displayPanel = new JPanel();

        displayPanel.add(new JScrollPane(txtDisplay));

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnInsert);
        btnPanel.add(new JLabel("  "));
        btnPanel.add(btnReset);
        btnPanel.add(new JLabel("  "));
        btnPanel.add(btnClose);

        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String carModel = (String) cmbCarModel.getSelectedItem();
                String carYear = (String) cmbCarYear.getSelectedItem();
                String carEng = (String) cmbEng.getSelectedItem();
                String carCID = (String) cmbCID.getSelectedItem();
                String carRlink = (String) cmbRlink.getSelectedItem();
                // int rLink = Integer.parseInt(carRlink);
                String carDesc = (String) cmbDesc.getSelectedItem();
                String carLTR = (String) cmbLTR.getSelectedItem();
                int index = cmbCarMakers.getSelectedIndex();
                String carMaker = carTable[index];
                CarDeletePanel.carChosen = carMakers[index];
                String result = CarInsert.insertCar(con, carModel, carYear,
                        carMaker, carDesc, carLTR, carEng, carCID, carRlink);

                txtDisplay.setText(result);

            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cmbCarModel.removeAllItems();
                cmbCarYear.removeAllItems();
                txtDisplay
                        .setText("Please choose Model you want to add new Year of."
                                + "\nPlease follow the instruction carefully."
                                + "\nP.S.:You cannot add new Model or Maker.");
            }
        });

        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CarModPanel.frameInsert.dispose();
            }
        });

        add(makerPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

    }

}