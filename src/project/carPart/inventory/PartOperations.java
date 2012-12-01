package project.carPart.inventory;

import java.sql.*;
import java.util.ArrayList;

public class PartOperations {

    static final int mARS = 1;
    static final int mMOD = 2;
    static final int mBEH = 3;
    static final int mDAN = 4;

    public static void addPart(Connection con, int m, String pnum,
            ArrayList<String> al) {
        String query = "INSERT INTO ";
        String manu = "";
        try {
            Statement createStatement = con.createStatement();
            manu = getManufacturerTable(m);
            checkNum(pnum);
            if (existsIn(con, m, pnum))
                throw new IllegalArgumentException(
                        "This Part Number already exists");

            checkNum(al.get(7));// check price float
            checkNum(al.get(8));// check amount int

            query += manu + " VALUES('" + pnum + "','" + al.get(0) // core
                    + "','" + al.get(1) // inhead
                    + "','" + al.get(2) // outhead
                    + "','" + al.get(3) // incon
                    + "','" + al.get(4) // oucon
                    + "','" + al.get(5) // tmount
                    + "','" + al.get(6) // oilcool
                    + "','" + al.get(7) + "','" + al.get(8) + "')";
            createStatement.executeUpdate(query);
            createStatement.execute("commit");
            PartAddPanel.warning.setText(manu.substring(4) + " Part #" + pnum
                    + " added");
            Log.log.add("Added new " + manu.substring(4) + " Part #" + pnum);
        } catch (IllegalArgumentException e) {
            PartAddPanel.warning.setText(e.getMessage());
        } catch (SQLException e) {
            PartAddPanel.warning.setText(e.getMessage());
        }
    }

    public static void delPart(Connection con, int m, String pnum) {
        String query = "DELETE FROM ";
        String manu = "";
        try {
            Statement createStatement = con.createStatement();
            manu = getManufacturerTable(m);
            checkNum(pnum);
            if (!existsIn(con, m, pnum))
                throw new IllegalArgumentException(
                        "This Part Number does NOT exist");

            query += manu + " WHERE P_NUMBER = '" + pnum + "'";

            System.out.println(query);
            createStatement.executeUpdate(query);
            createStatement.execute("commit");
            
            String manuName = getManufacturerName(m);
            for (int i = 1; i <= 4; i++) {
                query = "UPDATE RADCRX " + "SET " + manuName + i + " = NULL WHERE " + manuName + i + " = '"
                        + pnum + "'";
                System.out.println(query);
                createStatement.executeUpdate(query);
                createStatement.execute("commit");
            }
            
            PartDelPanel.warning.setText(manu.substring(4) + " Part #" + pnum
                    + " deleted");
            Log.log.add("Deleted new " + manu.substring(4) + " Part #" + pnum);
        } catch (IllegalArgumentException e) {
            PartDelPanel.warning.setText(e.getMessage());
        } catch (SQLException e) {
            PartDelPanel.warning.setText(e.getMessage());
        }
    }

    public static boolean getPart(Connection con, int m, String pnum) {
        String query = "SELECT * FROM ";
        String manu = "";
        try {
            Statement createStatement = con.createStatement();
            checkNum(pnum);
            if (!existsIn(con, m, pnum))
                throw new IllegalArgumentException("This Part # does NOT exist");
            manu = getManufacturerTable(m);
            query += manu + " WHERE P_NUMBER = '" + pnum + "'";
            System.out.println(query);
            ResultSet rs = createStatement.executeQuery(query);
            if (rs.next()) {
                PartUpdatePanel.oldPnum = rs.getString("P_NUMBER");
                PartUpdatePanel.oldValues.removeAll(PartUpdatePanel.oldValues);
                for (int i = 2; i <= 10; i++) {
                    PartUpdatePanel.oldValues.add(rs.getString(i));
                }
                PartUpdatePanel.warning.setText(manu.substring(4) + " Part #"
                        + pnum + " retrieved");
            }
        } catch (IllegalArgumentException e) {
            PartUpdatePanel.warning.setText(e.getMessage());
            return false;
        } catch (SQLException e) {
            PartUpdatePanel.warning.setText(e.getMessage());
            return false;
        }
        return true;
    }

    public static void updatePart(Connection con, int m, String pnum,
            ArrayList<String> al) {
        String query = "UPDATE ";
        String manu = "";
        boolean pNumChanged = false;
        try {
            Statement createStatement = con.createStatement();
            manu = getManufacturerTable(m);
            checkNum(pnum);
            if (!pnum.equals(PartUpdatePanel.oldPnum)) {
                pNumChanged = true;
                if (existsIn(con, m, pnum))
                    throw new IllegalArgumentException(manu.substring(4)
                            + " Part #" + pnum + " ALREADY exists");
            }

            checkNum(al.get(7));// check price float
            checkNum(al.get(8));// check amount int

            query += manu + " SET P_NUMBER = '" + pnum + "'"
                    + ", CORE = '"
                    + al.get(0) // core
                    + "', INHEAD = '"
                    + al.get(1) // inhead
                    + "', OUTHEAD = '"
                    + al.get(2) // outhead
                    + "', INCON = '"
                    + al.get(3) // incon
                    + "', OUCON = '"
                    + al.get(4) // oucon
                    + "', TMOUNT = '"
                    + al.get(5) // tmount
                    + "', OILCOOL = '"
                    + al.get(6) // oilcool
                    + "', PRICE = '" + al.get(7) + "', AMOUNT = '" + al.get(8)
                    + "' WHERE P_NUMBER = '" + PartUpdatePanel.oldPnum + "'";
            System.out.println(query);
            createStatement.executeUpdate(query);
            createStatement.execute("commit");
            if (pNumChanged) {
                updateRLinkPNum(con, m, pnum, PartUpdatePanel.oldPnum);
                Log.log.add("Updated new " + manu.substring(4) + " Part #"
                        + PartUpdatePanel.oldPnum + " to #" + pnum);
            }
            PartUpdatePanel.warning.setText(manu.substring(4) + " Part #"
                    + pnum + " updated");
            Log.log.add("Updated new " + manu.substring(4) + " Part #" + pnum);

        } catch (IllegalArgumentException e) {
            PartUpdatePanel.warning.setText(e.getMessage());
        } catch (SQLException e) {
            PartUpdatePanel.warning.setText(e.getMessage());
        }

    }

    public static void checkNum(String s) {
        int dot = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.' && dot <= 0)
                dot++;
            else if (s.charAt(i) == '.' && dot > 0)
                throw new IllegalArgumentException(s + " is NOT a VALID Number");
            else if (!Character.isDigit(s.charAt(i)))
                throw new IllegalArgumentException(s + " is NOT a VALID Number");
        }
    }

    public static boolean existsIn(Connection con, int m, String pnum) {
        String query = "SELECT * from ";
        try {
            Statement createStatement = con.createStatement();
            switch (m) {
            case mARS:
                query += "RDIMARS";
                break;
            case mMOD:
                query += "RDIMMOD";
                break;
            case mBEH:
                query += "RDIMBEH";
                break;
            case mDAN:
                query += "RDIMDAN";
                break;
            }
            query += " WHERE P_number = '" + pnum + "'";
            ResultSet rset = createStatement.executeQuery(query);
            String r = "";
            while (rset.next()) {
                r = (rset.getString(1));
                if (r.equals(pnum))
                    return true;
            }
            return false;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static String getManufacturerTable(int m) {
        String manu = "";
        switch (m) {
        case mARS:
            manu += "RDIMARS";
            break;
        case mMOD:
            manu += "RDIMMOD";
            break;
        case mBEH:
            manu += "RDIMBEH";
            break;
        case mDAN:
            manu += "RDIMDAN";
            break;
        }
        return manu;
    }

    public static String getManufacturerName(int m) {
        String manu = "";
        switch (m) {
        case mARS:
            manu += "ARS";
            break;
        case mMOD:
            manu += "MOD";
            break;
        case mBEH:
            manu += "BEH";
            break;
        case mDAN:
            manu += "DAN";
            break;
        }
        return manu;
    }

    public static void updateRLinkPNum(Connection con, int m, String pnum,
            String oldPnum) {
        try {
            Statement createStatement = con.createStatement();
            String query = "";
            String manuName = getManufacturerName(m);
            for (int i = 1; i <= 4; i++) {
                query = "UPDATE RADCRX " + "SET " + manuName + i + " = '"
                        + pnum + "'" + " WHERE " + manuName + i + " = '"
                        + oldPnum + "'";
                System.out.println(query);
                createStatement.executeUpdate(query);
                createStatement.execute("commit");
            }
        } catch (IllegalArgumentException e) {
            PartUpdatePanel.warning.setText(e.getMessage());
        } catch (SQLException e) {
            PartUpdatePanel.warning.setText(e.getMessage());
        }
    }
}
