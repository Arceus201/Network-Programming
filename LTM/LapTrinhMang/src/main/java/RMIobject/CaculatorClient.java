/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMIobject;

/**
 *
 * @author Admins
 */
import RMIxulychuoi.*;
import RMI.*;
import java.net.MalformedURLException;
import java.rmi.*;
import java.text.ParseException;
import java.util.Scanner;
public class CaculatorClient {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, ParseException {
            Scanner in = new Scanner(System.in);
            System.out.println("Nhap Object so");
             SinhVien sv =new SinhVien(in.nextLine(),in.nextLine(),Float.parseFloat(in.nextLine()),Float.parseFloat(in.nextLine()),
                     Float.parseFloat(in.nextLine()));

            System.out.println("Tim bai co ma la: Ma bai + MSV");
            // tim doi tuong tu xa theo ten dang ky
            CaculatorInterface cal = (CaculatorInterface) Naming.lookup("rmi://localhost/B3B19DCCN300");
            // trieu goi phuong thuc tu xa
            System.out.println("B3;"+cal.xuly(sv));
       
    }
}
