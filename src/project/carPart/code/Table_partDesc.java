/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.carPart.code;

import java.sql.ResultSet;
import project.carPart.query_db.DBQuery;

/**
 *
 * @author phoenx97
 */
public class Table_partDesc {
    public static ResultSet table_partDesc(String vendor, String part) {
        ResultSet rs;

        try {
            rs = DBQuery.getPartDesc(vendor, part);
            return rs;
        }
        catch (Exception e) {
            System.out.println("error trying to create part desc table: " + e);
        }
        return null;
    }
}
