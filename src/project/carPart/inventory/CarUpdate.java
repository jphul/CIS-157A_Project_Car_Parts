package project.carPart.inventory;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class is in charge to do Car updates.
 */
public class CarUpdate {
    static ArrayList<String> curTuple = new ArrayList<String>(7);

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
            CarUpdatePanel.cmbCarModel.removeAllItems();

        CarUpdatePanel.cmbCarYear.removeAllItems();
        ResultSet rs = null;
        String stmntStr = "";
        if (!where)
            stmntStr = "SELECT DISTINCT " + attr + " FROM " + table;
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

    public static void getCarInfo(Connection con, String model, String year,
            String table, int index) {

        ResultSet rs = null;
        String getAllInfo = "SELECT Description, Litres ltr, Engine_type Eng,"
                + " Cubic_inches CID, Rlink FROM " + table + " WHERE MODEL = '"
                + model + "' AND YEAR = '" + year + "'";
        String des = "";

        try {
            Statement stmnt = con.createStatement();
            rs = stmnt.executeQuery(getAllInfo);

            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfColumns = rsMetaData.getColumnCount();
            des = String.format("%s%40s", "DESCRIPTION", " ");
            for (int i = 2; i <= numberOfColumns; i++) {
                des += rsMetaData.getColumnName(i) + "\t";
            }
            des += "\n---------------------------------------------------------"
                    + "---------------------------------------------------"
                    + "--------------\n";

            int s = 0;
            String st = "";
            while (rs.next()) {

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
                des += st + rs.getString(2) + "\t" + rs.getString(3) + "\t"
                        + rs.getString(4) + "\t" + rs.getInt(5) + "\n";

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        des += "\n";
        CarUpdatePanel.txtDisplay.setText(des);
    }// Method

    public static ArrayList<String> getDesc(Connection con, String model,
            String year, String table) {

        ArrayList<String> result = new ArrayList<String>();
        String getDes = "SELECT DISTINCT Description FROM " + table
                + " WHERE MODEL = '" + model + "' AND YEAR = " + year
                + " Order by Description";
        try {
            Statement createStatement = con.createStatement();
            ResultSet rset = createStatement.executeQuery(getDes);
            // ResultSetMetaData rsMetaData = rset.getMetaData();
            while (rset.next()) {
                result.add(rset.getString(1));

            }

            return result;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            result.add(ex.getMessage());
            return result;
        }
    }

    /**
     * 
     * @param con
     * @param model
     * @param year
     * @param table
     * @param desc
     * @return
     */

    public static ArrayList<String> getLTR(Connection con, String model,
            String year, String table, String desc) {

        ArrayList<String> result = new ArrayList<String>();
        String getDes = "SELECT DISTINCT Litres FROM " + table
                + " WHERE MODEL = '" + model + "' AND YEAR = " + year
                + " AND DESCRIPTION = '" + desc + "' Order By Litres";
        try {
            Statement createStatement = con.createStatement();
            ResultSet rset = createStatement.executeQuery(getDes);

            while (rset.next()) {
                result.add(rset.getString(1));

            }

            return result;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            result.add(ex.getMessage());
            return result;
        }
    }

    public static ArrayList<String> getEng(Connection con, String model,
            String year, String table, String desc, String ltr) {

        ArrayList<String> result = new ArrayList<String>();
        String getDes = "SELECT DISTINCT Engine_type FROM " + table
                + " WHERE MODEL = '" + model + "' AND YEAR = " + year
                + " AND DESCRIPTION = '" + desc + "' AND Litres = '" + ltr
                + "' Order By Engine_type";
        try {
            Statement createStatement = con.createStatement();
            ResultSet rset = createStatement.executeQuery(getDes);
            while (rset.next()) {
                result.add(rset.getString(1));

            }

            return result;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            result.add(ex.getMessage());
            return result;
        }
    }

    public static ArrayList<String> getCID(Connection con, String model,
            String year, String table, String desc, String ltr, String eng) {

        ArrayList<String> result = new ArrayList<String>();
        String getDes = "SELECT DISTINCT CUBIC_INCHES FROM " + table
                + " WHERE MODEL = '" + model + "' AND YEAR = " + year
                + " AND DESCRIPTION = '" + desc + "' AND Litres = '" + ltr
                + "' AND Engine_type = '" + eng + "'";
        try {
            Statement createStatement = con.createStatement();
            ResultSet rset = createStatement.executeQuery(getDes);
            while (rset.next()) {
                result.add(rset.getString(1));

            }

            return result;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            result.add(ex.getMessage());
            return result;
        }
    }

    public static ArrayList<String> getRlink(Connection con, String model,
            String year, String table, String desc, String ltr, String eng,
            String CID) {

        ArrayList<String> result = new ArrayList<String>();
        String getDes = "SELECT DISTINCT Rlink FROM " + table
                + " WHERE MODEL = '" + model + "' AND YEAR = " + year
                + " AND DESCRIPTION = '" + desc + "' AND Litres = '" + ltr
                + "' " + "AND Engine_type = '" + eng + "' AND CUBIC_INCHES = '"
                + CID + "'";
        try {
            Statement createStatement = con.createStatement();
            ResultSet rset = createStatement.executeQuery(getDes);
            while (rset.next()) {
                result.add(rset.getString(1));
            }

            return result;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            result.add(ex.getMessage());
            return result;
        }
    }

    public static String update(Connection con, String model, String year,
            String table, String desc, String ltr, String eng, String CID,
            String rl) {
        int rlNum = Integer.parseInt(rl);
        try {
            if (rlNum <= 0)
                throw new IllegalArgumentException("Invalid RLink number!");
            try {
                Statement createStatement = con.createStatement();
                ResultSet rset = createStatement
                        .executeQuery("SELECT count(*) from RADCRX");
                String r = "";
                while (rset.next()) {
                    r = (rset.getString(1));
                }
                int maxRlink = Integer.parseInt(r);
                if (rlNum > maxRlink) {
                    throw new IllegalArgumentException(
                            "This RLink NOT exists\n"
                                    + "You can leave this window open and "
                                    + "\"Create New RLink\" before continue.");
                    /**
                     * create new empty RLink rset = createStatement
                     * .executeQuery("INSERT INTO RADCRX(rlink) VALUES (" +
                     * maxRlink++ + ")");
                     **/
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                String result = (ex.getMessage());
                return result;
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

        try {
            Statement stmnt = con.createStatement();
            stmnt.executeUpdate("update " + table + " set model ='" + model
                    + "' ,year ='" + year + "' ,description ='" + desc
                    + "' ,litres ='" + ltr + "',engine_type='" + eng
                    + "' ,cubic_inches='" + CID + "' ,rlink= " + rlNum
                    + " WHERE MODEL = '" + curTuple.get(0) + "' AND YEAR = '"
                    + curTuple.get(1) + "' AND DESCRIPTION = '"
                    + curTuple.get(2) + "' AND Litres = '" + curTuple.get(3)
                    + "' AND Engine_type = '" + curTuple.get(4)
                    + "' AND CUBIC_INCHES = '" + curTuple.get(5)
                    + "' AND Rlink = " + curTuple.get(6));

            // stmnt.executeUpdate("INSERT INTO " + table + " VALUES ('" + model
            // + "','" + year + "','" + desc + "','" + ltr + "','" + eng
            // + "','" + CID + "','" + rlNum + "')");

            stmnt.execute("commit");
            String result = model + " " + year + " updated";
            return result;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return ex.getMessage();
        }

    }
}