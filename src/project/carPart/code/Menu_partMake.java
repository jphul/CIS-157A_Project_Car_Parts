/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.carPart.code;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import project.carPart.query_db.DBQuery;

/**
 *
 * @author Sean-Laptop
 */
public class Menu_partMake 
{
    public static Object[] menu_partVendors() 
    {
        ResultSet rs;
        ArrayList<String> resultString = new ArrayList<String>();

        try
        {
            rs = DBQuery.getVendorMenuItems();

            while(rs.next()) 
                resultString.add(rs.getString(1));

        } catch (SQLException sqle) {System.out.println("sql exception while getting vendor names");}

        return resultString.toArray();
    }
    
    public static Object[] menu_PartNumbers(String partVendor)
    {
        ArrayList<String> resultString = new ArrayList<String>();
        try
        {
            ResultSet rs = DBQuery.getVendorPartNumbers(partVendor);
            
            while(rs.next())
                resultString.add(rs.getString(1));
        } catch (SQLException sqle) { System.out.println("sql exception while getting vendor part numbers"); }
        
        return resultString.toArray();
    }
}
