/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.sql.*;
import java.awt.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Mark {

    Connection c = database.connect_db.getConnection();
    PreparedStatement ps;

    public void get_mark_by_stuID(JTable table, String maSV, String schoolYear, int semester) {
        String sql = "select distinct semester, mark.schoolYear, mark.mark, class.maLop, credit, className from student"
                + " join mark on mark.masv = student.masv"
                + " join class on class.malop = mark.malop"
                + " join study on study.malop = class.malop"
                + " where student.maSV = ? and mark.schoolYear=? and semester=?";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, maSV);
            ps.setString(2, schoolYear);
            ps.setInt(3, semester);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getInt(5));
                v.add(rs.getString(6));
                model.addRow(v);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Mark.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public double sum_mark(String maSV, String schoolYear, int semester) {
        String sql = "select mark, credit from mark"
                + " join student on student.maSV = mark.maSV"
                + " join class on class.maLop = mark.maLop"
                + " join study on study.maLop = class.maLop"
                + " where student.masv=? and mark.schoolYear = ? and semester = ?;";
        double tongDiem = 0.0;
        int tongTinChi = 0;
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, maSV);
            ps.setString(2, schoolYear);
            ps.setInt(3, semester);
            ResultSet rs = ps.executeQuery();
            int i = 1, j = i + 1;
            int tinChi = 0;
            // ds la Diem So
            double ds = 0;
            String dc;
            while (rs.next()) {
                // dc la Diem chu
                dc = new String(rs.getString(i));
                tinChi = rs.getInt(j);
                tongTinChi += tinChi;
                if (dc.equals("A")) {
                    ds += 4;
                } else if (dc.equals("B+")) {
                    ds += 3.5;
                } else if (dc.equals("B")) {
                    ds += 3;
                } else if (dc.equals("C+")) {
                    ds += 2.5;
                } else if (dc.equals("C")) {
                    ds += 2;
                } else if (dc.equals("D+")) {
                    ds += 1.5;
                } else if (dc.equals("D")) {
                    ds += 1;
                } else if (dc.equals("F")) {
                    ds += 0;
                }
                tongDiem += ds * tinChi;
                ds = 0;
                tinChi = 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mark.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tongDiem / tongTinChi;
    }

    // test lay diem va tin chi
//    public static void main(String[] args) {
//        Mark test = new Mark();
//        System.out.println(test.sum_mark("B2110084", "2021-2022", 1));
//    }
}
