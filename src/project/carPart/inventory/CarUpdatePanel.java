package project.carPart.inventory;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;



@SuppressWarnings("serial")
class CarUpdatePanel extends JPanel {
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
    final CarUpdate update = new CarUpdate();
    final Connection con = dbConn.getDBConnection();

    JComboBox<String> cmbCarMakers;
    static JComboBox<String> cmbCarModel;
    static JComboBox<String> cmbCarYear;
    static JComboBox<String> cmbDesc;
    static JComboBox<String> cmbEng;
    static JComboBox<String> cmbCID;
    static JComboBox<String> cmbRlink;
    static JComboBox<String> cmbLTR;
    static JComboBox<Object> newModel;
    static JComboBox<String> newYear;
    static JComboBox<Object> newDes;
    static JComboBox<Object> newEng;
    static JComboBox<Object> newCID;
    static JComboBox<Object> newRLink;
    static JComboBox<Object> newLit;
    JButton btnReset = new JButton("Reset");
    JButton btnClose = new JButton("Cancel");
    JButton btnSave = new JButton("Save");
    static JTextArea txtDisplay = new JTextArea(
            "Select a Car from the Top boxes"
                    + "\nThen Modify the details in the Bottom boxes", 10, 35);

    public CarUpdatePanel() {

        cmbCarMakers = new JComboBox<String>();

        for (int i = 0; i < carMakers.length; i++) {
            cmbCarMakers.addItem(carMakers[i]);
        }

        setLayout(new BorderLayout());
        JPanel makerPanel = new JPanel();
        makerPanel.setName("Select Car");
        makerPanel.setLayout(new GridLayout(10, 1));
        makerPanel.add(new JLabel("Select Car Marker:"));
        makerPanel.add(cmbCarMakers);
        cmbCarMakers.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {

                int carIndex = cmbCarMakers.getSelectedIndex();
                ArrayList<String> modelList = CarUpdate.getInfo(con, "model",
                        carTable[carIndex], false);
                int t = cmbCarModel.getItemCount();
                System.out.println(t);
                for (int i = 0; i < modelList.size(); i++) {
                    cmbCarModel.addItem(modelList.get(i));
                    newModel.addItem(modelList.get(i));
                }

                txtDisplay.setVisible(true);

            }
        });

        cmbCarModel = new JComboBox<String>();

        makerPanel.add(new JLabel("Select Car Model:"));
        makerPanel.add(cmbCarModel);

        cmbCarModel.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {

                ArrayList<String> yearList = CarUpdate.getInfo(con,
                        (String) cmbCarModel.getSelectedItem(),
                        carTable[cmbCarMakers.getSelectedIndex()], true);
                newYear.removeAllItems();
                newModel.removeAllItems();
                newModel.addItem(cmbCarModel.getSelectedItem());
                for (int i = 0; i < yearList.size(); i++) {
                    cmbCarYear.addItem(yearList.get(i));
                    newYear.addItem(yearList.get(i));
                }

            }
        });

        cmbCarYear = new JComboBox<String>();
        makerPanel.add(new JLabel("Select/Enter Car Year: (2 Digit numbers)"));
        makerPanel.add(cmbCarYear);

        cmbCarYear.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie) {

                String model = (String) cmbCarModel.getSelectedItem();
                String year = (String) cmbCarYear.getSelectedItem();

                int carIndex = cmbCarMakers.getSelectedIndex();

                CarUpdate.getCarInfo(con, model, year, carTable[carIndex],
                        carIndex);

                desc = CarUpdate.getDesc(con, model, year, carTable[carIndex]);
                System.out.println(desc);
                cmbDesc.removeAllItems();
                newDes.removeAllItems();
                cmbDesc.addItem("");
                newDes.addItem("");
                for (int i = 0; i < desc.size(); i++) {
                    cmbDesc.addItem(desc.get(i));
                    newDes.addItem(desc.get(i));
                }

            }
        });

        cmbDesc = new JComboBox<String>();
        makerPanel.add(new JLabel("Select a Description: "));
        makerPanel.add(cmbDesc);

        cmbDesc.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie) {

                String model = (String) cmbCarModel.getSelectedItem();
                String year = (String) cmbCarYear.getSelectedItem();
                int carIndex = cmbCarMakers.getSelectedIndex();
                String desc = (String) cmbDesc.getSelectedItem();
                newDes.removeAllItems();
                newDes.addItem(cmbDesc.getSelectedItem());
                LTR = CarUpdate.getLTR(con, model, year, carTable[carIndex],
                        desc);
                System.out.println(desc);
                cmbLTR.removeAllItems();
                newLit.removeAllItems();
                for (String s : LTR) {
                    cmbLTR.addItem(s);
                    newLit.addItem(s);
                }

            }
        });

        cmbLTR = new JComboBox<String>();
        makerPanel.add(new JLabel("Select a Litres(maximum 4 characters): "));
        makerPanel.add(cmbLTR);

        cmbLTR.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie) {

                String model = (String) cmbCarModel.getSelectedItem();
                String year = (String) cmbCarYear.getSelectedItem();
                int carIndex = cmbCarMakers.getSelectedIndex();
                String desc = (String) cmbDesc.getSelectedItem();
                String ltr = (String) cmbLTR.getSelectedItem();

                newLit.removeAllItems();
                newLit.addItem(cmbLTR.getSelectedItem());
                Eng = CarUpdate.getEng(con, model, year, carTable[carIndex],
                        desc, ltr);
                System.out.println(desc);
                cmbEng.removeAllItems();
                newEng.removeAllItems();

                for (String s : Eng) {
                    cmbEng.addItem(s);
                    newEng.addItem(s);
                }

            }
        });

        cmbEng = new JComboBox<String>();
        makerPanel.add(new JLabel("Select an Eng(max 3 character): "));
        makerPanel.add(cmbEng);

        cmbEng.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie) {

                String model = (String) cmbCarModel.getSelectedItem();
                String year = (String) cmbCarYear.getSelectedItem();
                int carIndex = cmbCarMakers.getSelectedIndex();
                String desc = (String) cmbDesc.getSelectedItem();
                String ltr = (String) cmbLTR.getSelectedItem();
                String eng = (String) cmbEng.getSelectedItem();

                newEng.removeAllItems();
                newEng.addItem(cmbEng.getSelectedItem());
                CID = CarUpdate.getCID(con, model, year, carTable[carIndex],
                        desc, ltr, eng);
                System.out.println(desc);
                cmbCID.removeAllItems();
                newCID.removeAllItems();
                for (String s : CID) {
                    cmbCID.addItem(s);
                    newCID.addItem(s);
                }

            }
        });

        cmbCID = new JComboBox<String>();
        makerPanel.add(new JLabel("Select an CID(max 6 characters): "));
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

                newCID.removeAllItems();
                newCID.addItem(cmbCID.getSelectedItem());
                Rlink = CarUpdate.getRlink(con, model, year,
                        carTable[carIndex], desc, ltr, eng, cid);
                System.out.println(desc);
                cmbRlink.removeAllItems();
                newRLink.removeAllItems();
                for (String s : Rlink) {
                    cmbRlink.addItem(s);
                    newRLink.addItem(s);
                }

            }
        });

        cmbRlink = new JComboBox<String>();
        makerPanel.add(new JLabel("Select a Rlink(4 digits number):"));
        makerPanel.add(cmbRlink);

        cmbRlink.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie) {

                newRLink.removeAllItems();
                newRLink.addItem(cmbRlink.getSelectedItem());
            }
        });

        JPanel modifyPanel = new JPanel();
        modifyPanel.setLayout(new GridLayout(10, 1));
        newModel = new JComboBox<Object>();
        newModel.setEditable(true);
        modifyPanel.add(new JLabel("Enter New Car Model: "));
        modifyPanel.add(newModel);

        newYear = new JComboBox<String>();
        newYear.setEditable(true);
        modifyPanel.add(new JLabel("Enter New Car Year(2 Digit numbers): "));
        modifyPanel.add(newYear);

        newDes = new JComboBox<Object>();
        newDes.setEditable(true);
        modifyPanel.add(new JLabel("Enter New Description: "));
        modifyPanel.add(newDes);

        newLit = new JComboBox<Object>();
        newLit.setEditable(true);
        modifyPanel.add(new JLabel("Enter New Litres(Max 4 Characters): "));
        modifyPanel.add(newLit);

        newEng = new JComboBox<Object>();
        newEng.setEditable(true);
        modifyPanel.add(new JLabel("Enter New Engine(Max 3 Characters): "));
        modifyPanel.add(newEng);

        newCID = new JComboBox<Object>();
        newCID.setEditable(true);
        modifyPanel.add(new JLabel("Enter New CID(Max 6 Characters): "));
        modifyPanel.add(newCID);

        newRLink = new JComboBox<Object>();
        newRLink.setEditable(true);
        modifyPanel.add(new JLabel("Enter New RLink(4 Digit Number):"));
        modifyPanel.add(newRLink);

        JPanel displayPanel = new JPanel();
        displayPanel.add(new JScrollPane(txtDisplay));

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnSave);
        btnPanel.add(new JLabel(""));
        btnPanel.add(btnReset);
        btnPanel.add(new JLabel(""));
        btnPanel.add(btnClose);

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String carModel = (String) cmbCarModel.getSelectedItem();
                String carYear = (String) cmbCarYear.getSelectedItem();
                String carEng = (String) cmbEng.getSelectedItem();
                String carCID = (String) cmbCID.getSelectedItem();
                String carRlink = (String) cmbRlink.getSelectedItem();
                String carDesc = (String) cmbDesc.getSelectedItem();
                String carLTR = (String) cmbLTR.getSelectedItem();

                int index = cmbCarMakers.getSelectedIndex();
                String carMaker = carTable[index];

                CarUpdate.curTuple.add(carModel);
                CarUpdate.curTuple.add(carYear);
                CarUpdate.curTuple.add(carDesc);
                CarUpdate.curTuple.add(carLTR);
                CarUpdate.curTuple.add(carEng);
                CarUpdate.curTuple.add(carCID);
                CarUpdate.curTuple.add(carRlink);

                carModel = (String) newModel.getSelectedItem();
                carYear = (String) newYear.getSelectedItem();
                carEng = (String) newEng.getSelectedItem();
                carCID = (String) newCID.getSelectedItem();
                carRlink = (String) newRLink.getSelectedItem();
                carDesc = (String) newDes.getSelectedItem();
                carLTR = (String) newLit.getSelectedItem();
                index = cmbCarMakers.getSelectedIndex();
                carMaker = carTable[index];
                CarDeletePanel.carChosen = carMakers[index];
                String result = CarUpdate.update(con, carModel, carYear,
                        carMaker, carDesc, carLTR, carEng, carCID, carRlink);
                txtDisplay.setText(result);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cmbCarModel.removeAllItems();
                cmbCarYear.removeAllItems();
                newModel.removeAllItems();
                newYear.removeAllItems();
                newCID.removeAllItems();
                newDes.removeAllItems();
                newLit.removeAllItems();
                newRLink.removeAllItems();
                newEng.removeAllItems();
                txtDisplay.setText("");
            }
        });

        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CarModPanel.frameUpdate.dispose();
            }
        });

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        makerPanel.setPreferredSize(new Dimension(500, 200));
        add(makerPanel);
        displayPanel.setPreferredSize(new Dimension(500, 200));
        add(displayPanel);
        modifyPanel.setPreferredSize(new Dimension(500, 200));
        add(modifyPanel);

        add(btnPanel);

    }
}