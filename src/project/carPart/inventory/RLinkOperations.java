package project.carPart.inventory;

import java.sql.*;
import java.util.ArrayList;

public class RLinkOperations {

    // unused
    public static boolean existsRLink(Connection con, String s) {
        try {
            Statement createStatement = con.createStatement();
            ResultSet rset = createStatement
                    .executeQuery("SELECT * from RADCRX where RLINK = " + s);
            String r = "";
            while (rset.next()) {
                r = (rset.getString(1));
                if (r.equals(s))
                    return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Since RLINKs are already in order, so just add the next new RLINK.
     * 
     * @param con
     * @return
     */
    public static int getTotalRLink(Connection con) {
        int max = 0;
        try {
            Statement createStatement = con.createStatement();
            ResultSet rset = createStatement
                    .executeQuery("SELECT count(*) from RADCRX");
            String r = "";
            while (rset.next()) {
                r = (rset.getString(1));
            }
            max = Integer.parseInt(r);
        } catch (SQLException ex) {
        }
        return max;
    }

    public static boolean getRLink(Connection con, String s) {
        try {
            for (int i = 0; i < s.length(); i++)
                if (!Character.isDigit(s.charAt(i)))
                    throw new IllegalArgumentException(s
                            + " is NOT 4 Digit Number");

            int i = Integer.parseInt(s);
            if (i > RLinkUpdatePanel.rlNum)
                throw new IllegalArgumentException("RLink#" + i + " NOT exists");

            Statement createStatement = con.createStatement();
            ResultSet rs = createStatement
                    .executeQuery("SELECT * from RADCRX where rlink = " + i);

            if (rs.next())// move to data row
            {
                RLinkUpdatePanel.arsNum.removeAll(RLinkUpdatePanel.arsNum);
                RLinkUpdatePanel.arsNum.add(convert(rs.getString(2)));
                RLinkUpdatePanel.arsNum.add(convert(rs.getString(3)));
                RLinkUpdatePanel.arsNum.add(convert(rs.getString(4)));
                RLinkUpdatePanel.arsNum.add(convert(rs.getString(5)));

                RLinkUpdatePanel.behNum.removeAll(RLinkUpdatePanel.behNum);
                RLinkUpdatePanel.behNum.add(convert(rs.getString(10)));
                RLinkUpdatePanel.behNum.add(convert(rs.getString(11)));
                RLinkUpdatePanel.behNum.add(convert(rs.getString(12)));
                RLinkUpdatePanel.behNum.add(convert(rs.getString(13)));

                RLinkUpdatePanel.danNum.removeAll(RLinkUpdatePanel.danNum);
                RLinkUpdatePanel.danNum.add(convert(rs.getString(14)));
                RLinkUpdatePanel.danNum.add(convert(rs.getString(15)));
                RLinkUpdatePanel.danNum.add(convert(rs.getString(16)));
                RLinkUpdatePanel.danNum.add(convert(rs.getString(17)));

                RLinkUpdatePanel.modNum.removeAll(RLinkUpdatePanel.modNum);
                RLinkUpdatePanel.modNum.add(convert(rs.getString(6)));
                RLinkUpdatePanel.modNum.add(convert(rs.getString(7)));
                RLinkUpdatePanel.modNum.add(convert(rs.getString(8)));
                RLinkUpdatePanel.modNum.add(convert(rs.getString(9)));

                RLinkUpdatePanel.warning.setText("RLink# " + i + " retrieved");
            }

        } catch (IllegalArgumentException e) {
            RLinkUpdatePanel.warning.setText(e.getMessage());
            return false;
        } catch (SQLException ex) {
            RLinkUpdatePanel.warning.setText(ex.getMessage());
            return false;
        }
        return true;
    }

    public static String createRLink(Connection con, int rlNum,
            ArrayList<String> ars, ArrayList<String> beh,
            ArrayList<String> dan, ArrayList<String> mod) {
        try {
            Statement stmnt = con.createStatement();

            validate(ars);
            validate(beh);
            validate(dan);
            validate(mod);

            String statement = "insert into radcrx values(" + rlNum + ","
                    + ars.get(0) + "," + ars.get(1) + "," + ars.get(2) + ","
                    + ars.get(3) + "," + beh.get(0) + "," + beh.get(1) + ","
                    + beh.get(2) + "," + beh.get(3) + "," + dan.get(0) + ","
                    + dan.get(1) + "," + dan.get(2) + "," + dan.get(3) + ","
                    + mod.get(0) + "," + mod.get(1) + "," + mod.get(2) + ","
                    + mod.get(3) + ")";
            stmnt.executeUpdate(statement);
            stmnt.execute("commit");
            return "Success: RLink #" + rlNum + " is created";

        } catch (IllegalArgumentException e) {
            String rs = e.getMessage();
            return rs;
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }

    public static String updateRLink(Connection con, String rlS,
            ArrayList<String> ars, ArrayList<String> beh,
            ArrayList<String> dan, ArrayList<String> mod) {
        try {
            Statement stmnt = con.createStatement();
            checkInt(rlS);
            int rl = Integer.parseInt(rlS);
            validate(ars);
            validate(beh);
            validate(dan);
            validate(mod);

            String statement = "update radcrx " + "set ARS1 = " + ars.get(0)
                    + ", ARS2 = " + ars.get(1) + ", ARS3 = " + ars.get(2)
                    + ", ARS4 = " + ars.get(3) + ", BEH1 = " + beh.get(0)
                    + ", BEH2 = " + beh.get(1) + ", BEH3 = " + beh.get(2)
                    + ", BEH4 = " + beh.get(3) + ", DAN1 = " + dan.get(0)
                    + ", DAN2 = " + dan.get(1) + ", DAN3 = " + dan.get(2)
                    + ", DAN4 = " + dan.get(3) + ", MOD1 = " + mod.get(0)
                    + ", MOD2 = " + mod.get(1) + ", MOD3 = " + mod.get(2)
                    + ", MOD4 = " + mod.get(3) + " WHERE RLINK =" + rl;

            System.out.println(statement);
            stmnt.executeUpdate(statement);
            stmnt.execute("commit");
            return "Success: RLink #" + rl + " is updated";

        } catch (IllegalArgumentException e) {
            String rs = e.getMessage();
            // System.out.println(rs);
            return rs;
        } catch (SQLException ex) {
            // System.err.println(ex.getMessage());
            return ex.getMessage();
        }
    }

    public static void checkInt(String s) {
        for (int i = 0; i < s.length(); i++)
            if (!Character.isDigit(s.charAt(i)))
                throw new IllegalArgumentException(s + " is NOT 3 Digit Number");
    }

    public static void validate(ArrayList<String> al) {
        for (String s : al) {
            if (!s.equals("NULL")) {
                checkInt(s);
                if (Integer.parseInt(s) < 1000)
                    s = "\'" + s + "\'";
                else
                    throw new IllegalArgumentException(s
                            + " is NOT 3 Digit Number");
            }
        }
    }

    public static String convert(String s) {
        if (s == null)
            return "NULL";
        else
            return s;
    }
}
