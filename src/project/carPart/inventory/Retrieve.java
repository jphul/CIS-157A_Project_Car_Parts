package project.carPart.inventory;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class is in charge to do SQL operations.
 */
public class Retrieve {
    /**
     * Query and store a list of model or year of a selected car to an array
     * list
     * 
     * @param con
     *            database connection
     * @param attr
     *            a model of a selected car
     * @param table
     *            a table of car
     * @param where
     *            true if queried year where model = a selected model otherwise
     *            just query a model from a car (no WHERE indicated)
     * @return info a list of car model or years stored in an array list
     */
    public static ArrayList<String> getInfo(Connection con, String attr,
            String table, boolean where) {
        if (!where)
            RetrievePanel.cmbCarModel.removeAllItems();

        RetrievePanel.cmbCarYear.removeAllItems();
        ResultSet rs = null;
        String stmntStr = "";
        if (!where)
            stmntStr = "SELECT DISTINCT " + attr + " FROM " + table + " ORDER "
                    + "BY model";
        else
            stmntStr = "SELECT DISTINCT YEAR FROM " + table + " WHERE "
                    + "MODEL = '" + attr + "'";

        ArrayList<String> info = new ArrayList<String>();

        try {
            Statement stmnt = con.createStatement();
            rs = stmnt.executeQuery(stmntStr);

            while (rs.next()) {
                info.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return info;
    }

    public static ArrayList<Integer> getCarInfo(Connection con, String model,
            String year, String table, int index) {
        RetrievePanel.cmbRlink.removeAllItems();

        ResultSet rs = null;
        ArrayList<Integer> rlink = new ArrayList<Integer>();

        String stmntStr = "SELECT Description, Litres ltr, Engine_type Eng,"
                + " Cubic_inches CID, Rlink FROM " + table + " WHERE MODEL = '"
                + model + "' AND YEAR = '" + year + "'";
        String des = "";
        try {
            Statement stmnt = con.createStatement();
            rs = stmnt.executeQuery(stmntStr);

            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfColumns = rsMetaData.getColumnCount();

            System.out.println("\nHere is more info about the car you have"
                    + " selected to retrieve.\n" + "Car maker: "
                    + RetrievePanel.carMakers[index] + "\nModel: " + model
                    + "\nYear: " + year);
            // ComboPanel.txtDisplay.setText(String.format("%s%40s",
            // "DESCRIPTION", ""));
            des = String.format("%s%40s", "DESCRIPTION", " ");
            // des = "DESCRIPTION\t\t\t";
            System.out.print(String.format("%s%40s", "DESCRIPTION", " "));
            for (int i = 2; i <= numberOfColumns; i++) {
                System.out.print(rsMetaData.getColumnName(i) + "\t");
                // ComboPanel.txtDisplay.setText(rsMetaData.getColumnName(i) +
                // "\t");
                des += rsMetaData.getColumnName(i) + "\t";
            }
            System.out.println();
            des += "\n---------------------------------------------------------"
                    + "---------------------------------------------------"
                    + "--------------\n";

            int s = 0;
            String st = "";
            while (rs.next()) {

                int spaces = 51 - rs.getString(1).length();
                String str = String.format("%s" + "%" + spaces + "s",
                        rs.getString(1), " ");
                if (rs.getString(1).length() < 11) {
                    s = 51 - rs.getString(1).length()
                            + (15 - rs.getString(1).length());
                    st = String.format("%s" + "%" + s + "s", rs.getString(1),
                            " ");
                } else {
                    s = 51 - rs.getString(1).length()
                            - (rs.getString(1).length() - 6);
                    st = String.format("%s" + "%" + s + "s", rs.getString(1),
                            " ");
                }

                System.out.print(str);
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.print(rs.getString(4) + "\t");
                rlink.add(rs.getInt(5));
                System.out.println(rs.getInt(5));
                des += st + rs.getString(2) + "\t" + rs.getString(3) + "\t"
                        + rs.getString(4) + "\t" + rs.getInt(5) + "\n";

            }
            System.out.println(s);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        des += "\n";
        RetrievePanel.txtDisplay.setText(des);
        return rlink;
    }// Method

    public static ArrayList<String> getPartInfo(Connection con, String attr,
            Object rl) {
        String rad = "";
        if (attr.equals("*"))
            ;
        RetrievePanel.cmbAMB.removeAllItems();
        // int li = Integer.parseInt(rl);
        ResultSet rs = null;
        ArrayList<String> part = new ArrayList<String>();

        String stmntStr = "SELECT " + attr + " FROM radcrx WHERE rlink = " + rl;

        try {
            Statement stmnt = con.createStatement();
            rs = stmnt.executeQuery(stmntStr);

            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfColumns = rsMetaData.getColumnCount();

            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.print(rsMetaData.getColumnName(i) + "\t");
                rad += rsMetaData.getColumnName(i) + "\t";
            }
            System.out.println();
            rad += "\n";

            while (rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                rad += rs.getInt(1) + "\t";
                for (int i = 2; i <= numberOfColumns; i++) {
                    String value = rs.getString(i);
                    System.out.print(value + "\t");
                    rad += value + "\t";
                    if (value != null && !value.equalsIgnoreCase("NS"))
                        part.add(rsMetaData.getColumnName(i));
                }
            }
            System.out.println();
            rad += "\n";
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        rad += "\n";
        RetrievePanel.txtDisplay.append(rad);
        return part;
    }// Method

    public static ArrayList<String> getPartInfo3(Connection con, String attr,
            Object rl) {
        String rad = "";

        // int li = Integer.parseInt(rl);
        ResultSet rs = null;
        ArrayList<String> part = new ArrayList<String>();

        String stmntStr = "SELECT " + attr + " FROM radcrx WHERE rlink = " + rl;

        try {
            Statement stmnt = con.createStatement();
            rs = stmnt.executeQuery(stmntStr);

            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfColumns = rsMetaData.getColumnCount();

            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.print(rsMetaData.getColumnName(i) + "\t");
                rad += rsMetaData.getColumnName(i) + "\t";
            }
            System.out.println();
            rad += "\n";

            while (rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                rad += rs.getInt(1) + "\t";
                for (int i = 2; i <= numberOfColumns; i++) {
                    String value = rs.getString(i);
                    System.out.print(value + "\t");
                    rad += value + "\t";
                    if (value != null && !value.equalsIgnoreCase("NS"))
                        part.add(rsMetaData.getColumnName(i));
                }
            }
            System.out.println();
            rad += "\n";
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        rad += "\n";
        RetrievePanel.txtDisplay.append(rad);
        return part;
    }// Method

    public static void getPartInfo2(Connection con, String table, String ambd,
            Object rlink) {
        ResultSet rs = null;
        String partDes = "";
        String stmntStr = "SELECT * FROM " + table + " WHERE p_number IN "
                + " (SELECT " + ambd + " FROM radcrx WHERE rlink = " + rlink
                + ")";

        try {
            Statement stmnt = con.createStatement();
            rs = stmnt.executeQuery(stmntStr);
            RetrievePanel.txtDisplay.append("Descriptions of Radiator Part:\n");

            partDes += "PNUMBER\t";
            partDes += "CORE\t\t";
            partDes += "INHEAD\t";
            partDes += "OUTHEAD\t";
            partDes += "INCON\t";
            partDes += "OUTCON\t";
            partDes += "TMOUNT\t\t";
            partDes += "OILCOOL\t";
            partDes += "PRICE\t";
            partDes += "AMOUNT\t";

            partDes += "\n-----------------------------------------------------"
                    + "------------------------------------------------------------"
                    + "------------------------------------------------------------"
                    + "------------------------------------------------------------"
                    + "-----------------------\n";

            while (rs.next()) {

                partDes += rs.getString(1) + "\t";
                partDes += rs.getString(2) + "\t";
                partDes += rs.getString(3) + "\t";
                partDes += rs.getString(4) + "\t";
                partDes += rs.getString(5) + "\t";
                partDes += rs.getString(6) + "\t";
                partDes += rs.getString(7) + "\t";
                partDes += rs.getString(8) + "\t";
                partDes += rs.getDouble(9) + "\t";
                partDes += rs.getInt(10);

            }
            System.out.println();
            partDes += "\n";
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        RetrievePanel.txtDisplay.append(partDes + "\n");
    }// Method
}