/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyHangHoa;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class HangHoa {
//    db database = new db();
//    Connection c = database.getConnection();
//    PreparedStatement ps;
    Connection c = new db().getConnection();
    PreparedStatement ps;
    public void themHangHoa(String maHangHoa, String tenHang, String loaiHang, String nhaSanXuat, String donViTinh, int donGia, String ngayNhapHang){
        String sql = "insert into DVD values(?,?,?,?,?,?,?)";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, maHangHoa);
            ps.setString(2, tenHang);
            ps.setString(3, loaiHang);
            ps.setString(4, nhaSanXuat);
            ps.setString(5, donViTinh);
            ps.setInt(6, donGia);
            ps.setString(7, ngayNhapHang);
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Them thanh cong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
