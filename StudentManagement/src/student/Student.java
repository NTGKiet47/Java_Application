
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

public class Student {
    Connection c = connect_db.getConnection();
    PreparedStatement ps;
    
//    get table max row
    public int getMax(){
        int id = 0;
        Statement st;
        try {
            st = c.createStatement();
            ResultSet rs = st.executeQuery("Select max(student_id) from student");
            while(rs.next()){
                id = rs.getInt(1);
            }
            System.out.println("getMax runs sucessfully");
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id+1;
    }
//    them vao bang STUDENT
    public void insert(int id, String maSV, String name, String date_of_birth, String gender, String phoneNumber, String email, String address){
        String sql = "insert into student values(?,?,?,?,?,?,?,?)";
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, maSV);
            ps.setString(3, name);
            ps.setString(4, date_of_birth);
            ps.setString(5, gender);
            ps.setString(6, phoneNumber);
            ps.setString(7, email);
            ps.setString(8, address);
            if(ps.executeUpdate()> 0){
                JOptionPane.showMessageDialog(null, "Student added sucessfully");
            }
        } catch (Exception e) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, e);
        }
    }
// cap nhat
public void update(int id, String maSV, String name, String date_of_birth, String gender, String phoneNumber, String email, String address){
        String sql = "update student set maSV=?, name=?, date_of_birth=?, gender=?, phoneNumber=?, email=?, address=? where student_id = ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, maSV);
            ps.setString(2, name);
            ps.setString(3, date_of_birth);
            ps.setString(4, gender);
            ps.setString(5, phoneNumber);
            ps.setString(6, email);
            ps.setString(7, address);
            ps.setInt(8, id);
            if(ps.executeUpdate()> 0){
                JOptionPane.showMessageDialog(null, "Student updated sucessfully");
            }
        } catch (Exception e) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//    check if email has existed
    public boolean isEmailExist(String email, int id){
        try {
            ps = c.prepareStatement("select * from student where email = ? AND student_id != ?");
            ps.setString(1, email);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
//                tra ve true la EMAIL DA TON TAI
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        // tra ve false la EMAIL CHUA TON TAI --> THEM DUOC
    }
    public boolean isMaSVExist(String maSV, int id){
        try {
            ps = c.prepareStatement("select * from student where maSV = ? AND student_id != ?");
            ps.setString(1, maSV);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean check_maSV(String maSV){
        try {
            maSV.toUpperCase();
            ps = c.prepareStatement("select * from student where maSV = ?");
            ps.setString(1, maSV);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean isPhoneNumberExist(String phoneNumber, int id){
        try {
            ps = c.prepareStatement("select * from student where phoneNumber = ? AND student_id != ?");
            ps.setString(1, phoneNumber);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean isIdExist(int id){
        try {
            ps = c.prepareStatement("select * from student where student_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    // lay toan bo du lieu tu csdl ve bang =======> them HÀNG CŨ SẼ NẰM Ở TRÊN HÀNG MỚI
//    public void getStudentInfo(JTable table, String searchValue){
//        try {
//            String sql = "select * from student where concat(id, name, email, phoneNumber)like ? order by id desc";
//            ps = c.prepareStatement(sql);
//            ps.setString(1, "%"+searchValue+"%");
//            ResultSet rs = ps.executeQuery();
//            DefaultTableModel model = (DefaultTableModel) table.getModel();
//            Object[] row;
//            while(rs.next()){
//                row = new Object[7];
//                row[0] = rs.getInt(1);
//                row[1] = rs.getString(2);
//                row[2] = rs.getString(3);
//                row[3] = rs.getString(4);
//                row[4] = rs.getString(5);
//                row[5] = rs.getString(6);
//                row[6] = rs.getString(7);
//                model.addRow(row);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void getStudentInfo(JTable table, String searchValue){
        try {
            ps = c.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                model.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getStudentInfo_by_maSV(JTable table, String maSV){
        try {
            String sql = "select * from student where maSV = ?";
            ps = c.prepareStatement(sql);
            ps.setString(1, maSV);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while(rs.next()){
                row = new Object[7];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteStudentInfo(int id){
        int a = JOptionPane.showConfirmDialog(null, "Classes and marks will be remove", "Select", JOptionPane.YES_NO_OPTION);
        if(a==0){
            try {
                // thuc hien xoa
                ps = c.prepareStatement("delete from student where student_id = ?");
                ps.setInt(1, id);
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Student deleted sucessfully");
                }else{
                    JOptionPane.showMessageDialog(null, "Could not delete, error occured");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
            return;
    }
}
