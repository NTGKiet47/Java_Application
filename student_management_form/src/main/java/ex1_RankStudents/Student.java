/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1_RankStudents;

/**
 *
 * @author ADMIN
 */
public class Student {
    private String mssv, hoTen, namSinh, queQuan, diaChi, xepLoai;
    float diemTb;
    public Student(){
        mssv = new String();
        hoTen = new String();
        namSinh = new String();
        queQuan = new String();
        diaChi = new String();
        diemTb = 0.0f;
        xepLoai = new String();
    }

    public Student(String mssv, String hoTen, String namSinh, String queQuan, String diaChi, String xepLoai, float diemTb) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.diaChi = diaChi;
        this.xepLoai = xepLoai;
        this.diemTb = diemTb;
    }
    
}
