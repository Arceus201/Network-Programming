/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMItong2songuyen;

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
            System.out.println("Nhap 2 so");
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Tim bai co ma la: Ma bai + MSV");
            // tim doi tuong tu xa theo ten dang ky
            CaculatorInterface cal = (CaculatorInterface) Naming.lookup("rmi://localhost/B1B19DCCN300");
            // trieu goi phuong thuc tu xa
            System.out.println("B1;"+cal.addNum(a, b));
       
    }
}
