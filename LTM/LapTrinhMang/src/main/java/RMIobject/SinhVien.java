/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMIobject;

/**
 *
 * @author Admins
 */
import java.util.*;
import java.text.*;

public class SinhVien {
    private String hoten;
    private Date ns;
    private float diem1,diem2,diem3;
     public SinhVien(String hoten,String ns,float diem1,float diem2,float diem3) throws ParseException{   
        this.hoten = hoten;
        this.ns = new SimpleDateFormat("dd/mm/yyyy").parse(ns);
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 =diem3;
    }
     

    public String getHoten() {
        return hoten;
    }

    public Date getNs() {
        return ns;
    }

    public float getDiem1() {
        return diem1;
    }

    public float getDiem2() {
        return diem2;
    }

    public float getDiem3() {
        return diem3;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setNs(Date ns) {
        this.ns = ns;
    }

    public void setDiem1(float diem1) {
        this.diem1 = diem1;
    }

    public void setDiem2(float diem2) {
        this.diem2 = diem2;
    }

    public void setDiem3(float diem3) {
        this.diem3 = diem3;
    }
    
}
