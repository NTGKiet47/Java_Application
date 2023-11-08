/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyHangHoa;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class db {
    public Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://DESKTOP-T25SJIC\\SQLEXPRESS:1433;serverTrustCertificate=true;databaseName=DVDLibrary;user=sa;password=sa2019;encrypt=false";
            Connection con = DriverManager.getConnection(dbUrl);
            System.out.println("Connected sucessfully");
            return con;
        } catch (Exception ex) {
            System.out.println("Could not connected");
            ex.printStackTrace();
        }
        return null;
    }
}
