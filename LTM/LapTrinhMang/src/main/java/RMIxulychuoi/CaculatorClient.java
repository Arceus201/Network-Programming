/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMIxulychuoi;

/**
 *
 * @author Admins
 */
import RMI.*;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.Scanner;
public class CaculatorClient {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap chuoi so");
            String s = sc.nextLine();
            System.out.println("Tim bai co ma la: Ma bai + MSV");
            // tim doi tuong tu xa theo ten dang ky
            CaculatorInterface cal = (CaculatorInterface) Naming.lookup("rmi://localhost/B2B19DCCN300");
            // trieu goi phuong thuc tu xa
            System.out.println("B2;"+cal.xuly(s));
       
    }
}
