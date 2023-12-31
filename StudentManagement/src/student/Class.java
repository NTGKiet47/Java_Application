package student;

import database.connect_db;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Class {
    Connection c = connect_db.getConnection();
    PreparedStatement ps;
    
    public void get_class_by_stuID(JTable table, String maSV){
        try {
            String sql = "select distinct semester, schoolYear, credit, className from study"
                    + " join class on class.maLop = study.maLop"
                    + " join student on student.maSV = study.maSV"
                    + " where study.maSV = ? order by semester";
            ps = c.prepareStatement(sql);
            ps.setString(1, maSV);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getInt(3));
                v.add(rs.getString(4));
                model.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
