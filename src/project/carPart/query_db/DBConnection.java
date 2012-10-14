package project.carPart.query_db;

import java.sql.*;
/**
 *
 * @author Jerry Phul
 */
public class DBConnection
{
    // ........................ D A T A F I E L D S ............................//
    // ............. G L O B A L P R I V A T E C O N S T A N T S .............//
    private final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String DB_URL = "jdbc:oracle:thin:@localhost:1521:oradb";
    private final String USER_ID = "scott";
    private final String PASSWORD = "tiger";
    
    
    // ................. G L O B A L P R I V A T E V A R S ...................//
    /** hold a pointer to the database connection. */
    private Connection con;
    private String query;
    
    
    // ........................ C O N S T R U C T O R S ..........................//
    public void DBConnection() {
    } //constructor
    
    
    public void createConnection() {
       try {
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER_ID, PASSWORD);
            //System.err.println("DB Connected");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void createQuery() {
        this.query = null;
    }
    
    
    //.............................. G E T T E R S ...............................//
    /** get the database connection object. */
    private Connection getDBConnection() {
        return this.con;
    }
    
    /** get the query */
    public String getQuery() {
        return query;
    }
    

    //.............................. S E T T E R S ...............................//
    /** set db query */
    public void setQuery(String query) {
        this.query = query;
    }


    
    // ...................... P U B L I C M E T H O D S ........................//
    /** disconnect from the database. */
    public void disconnectFromDB() {
        try {
            con.close();
            //System.out.println("Disconnected from DB!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    } // method

    
    public ResultSet queryDb() {
        ResultSet rs = null;
        String stmntStr = this.getQuery();

        try {
            //Statement stmnt = con.createStatement();
            Statement stmnt = getDBConnection().createStatement();
            rs = stmnt.executeQuery(stmntStr);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return rs;
    }
    
} // class
