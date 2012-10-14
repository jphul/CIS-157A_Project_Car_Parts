/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.carPart.query_db;

import java.sql.*;
/**
 *
 * @author Jerry Phul
 */
public class DBQuery {
    
    //private static ResultSet DBQuery() {
    private static ResultSet DBQuery(String query) {
        DBConnection dbc = new DBConnection();
        dbc.createQuery();
        dbc.setQuery(query);
        dbc.createConnection();
        return dbc.queryDb();
//        dbc.disconnectFromDB();
    }

    private static String getMakeQuery() {
        //return "select Distinct maker from cmakers order by maker ASC";
        return "select Distinct mshort from cmakers order by mshort ASC";
    }

    public static ResultSet getMakeMenuItems() {
        return DBQuery(getMakeQuery());
    }

    private static String getModelQuery(String carModel) {
        return "select Distinct model from apl" + carModel;
    }

    public static ResultSet getModelMenuItems(String carMake) {
        return DBQuery(getModelQuery(carMake));
    }

    private static String getYearQuery(String carMake, String carModel) {
        return "select distinct year from APL" + carMake + " where MODEL='" + carModel + "'";
    }

    public static ResultSet getYears(String carMake, String carModel) {
        return DBQuery(getYearQuery(carMake, carModel));
    }

    private static String getEngDescQuery(String carMake, String carModel, String carYear) {
        //String query = "select description, litres as ltr, engine_type as ENG, Cubic_inches as CID, RLINK from aplche where model='BEL AIR' and year=74";
        String query = "select description, litres as ltr, engine_type as ENG, Cubic_inches as CID, RLINK from APL" + carMake + " where model='" + carModel + "' and year=" + carYear;
        System.err.println(query);
        return query;
    }
    
    //TODO: Need to add parameters to method and then update Table-carEngineDesc file with same
    public static ResultSet getTableEngineDesc(String carMake, String carModel, String carYear) {
        return DBQuery(getEngDescQuery(carMake, carModel, carYear));
    }

    private static String getPartQuery(int partNumber) {
        return "select * from rdimmod where P_Number in (select MOD4 from radcrx where rlink=" + partNumber + ")";
    }
    
    public static ResultSet getTablePartDesc(int partNumber) {
        return DBQuery(getPartQuery(partNumber));
    }

    
    // ........................ M A I N M E T H O D ............................//
    /**
    * @param args
    */
//    public static void main(String[] args) {
        
//    } // main method
}
