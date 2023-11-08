package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connect_db {
     
    public static Connection getConnection(){
        
        Connection c = null;
        try {
            String url = "jdbc:mySQL://localhost:3306/studentsmanagement";
            String username = "root";
            String password = "";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            c = DriverManager.getConnection(url, username, password);
            
            System.out.println("Connected sucessfully");
        } catch (SQLException ex) {
            Logger.getLogger(connect_db.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Could not connect to database");
        }
        return c;
    }
    public static void closeConnection(Connection c){
        try {
            if(c!= null){
                c.close();
                System.out.println("Close connection sucessfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(connect_db.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Could not close connection ");
        }
                
    }
}
