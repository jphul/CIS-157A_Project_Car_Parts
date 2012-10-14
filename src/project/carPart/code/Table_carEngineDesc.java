/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.carPart.code;

import java.sql.ResultSet;
import java.util.ArrayList;
import project.carPart.query_db.DBQuery;
import javax.swing.table.*;

/**
 *
 * @author Jerry Phul
 */
public class Table_carEngineDesc {
    
    public static ResultSet table_carEngineDesc(String carMake, String carModel, String carYear) {
        ResultSet rs;

        //TODO: Need to add params to the get method below
        rs = DBQuery.getTableEngineDesc(carMake, carModel, carYear);

        return rs;
    }

/*    public static DefaultTableModel tableModel_carEngineDesc() {
        //TODO: Code not needed
        ResultSet rs;
        Object data[][] = {{"Vinod","MCA","Computer"},
                      {"Deepak","PGDCA","History"},
                      {"Ranjan","M.SC.","Biology"},
                      {"Radha","BCA","Computer"}};
        String col[] = {"Name","Course","Subject"};
        DefaultTableModel model = new DefaultTableModel(data, col);
        
        //TODO: Need to add params to the get method below
        rs = DBQuery.getTableEngineDesc();

        try {
            while(rs.next()) {
                //data = rs.getString(1);
            }
        } catch(Exception e) {
            System.err.print(e.toString());
        }

        return model;
    }
*/
}
