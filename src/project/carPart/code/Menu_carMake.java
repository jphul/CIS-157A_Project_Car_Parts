/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.carPart.code;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import project.carPart.query_db.DBQuery;
import project.carPart.gui.*;


/**
 *
 * @author Jerry Phul
 */
public class Menu_carMake {
    
    
    public static Object[] menu_carModel(String carModel) {
        ResultSet rs;
        ArrayList resultString = new ArrayList();
        Object[] resultArray = null;

        rs = DBQuery.getModelMenuItems(carModel);

        try {
            while(rs.next()) {
                resultString.add(rs.getString(1));
            }
            resultArray = resultString.toArray();
        
        } catch(Exception e) {
            System.err.print("ERROR: " + e.toString());
        }

        return resultArray;
    }

    public static Object[] menu_carMake() {
        ResultSet rs;
        ArrayList resultString = new ArrayList();
        Object[] resultArray = null;

        rs = DBQuery.getMakeMenuItems();

        try {
            while(rs.next()) {
                resultString.add(rs.getString(1));
            }
            resultArray = resultString.toArray();
        } catch(Exception e) {
            System.err.print("ERROR: " + e.toString());
        }

        //Object[] resultArray = resultString.toArray();
        
        return resultArray;
    }

    public static Object[] menu_carYears(String carMake, String carModel) {
        ResultSet rs;
        ArrayList resultString = new ArrayList();

        rs = DBQuery.getYears(carMake, carModel);

        try {
            while(rs.next()) {
                resultString.add(rs.getString(1));
            }
        } catch(Exception e) {
            System.err.print(e.toString());
        }

        Object[] resultArray = resultString.toArray();
        
        return resultArray;
    }
}
