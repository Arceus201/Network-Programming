/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

/**
 *
 * @author Admins
 */
import java.net.MalformedURLException;
import java.rmi.*;
public class CaculatorClient {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
 
            System.out.println("Finding Object … ");
            // tim doi tuong tu xa theo ten dang ky
            CaculatorInterface cal = (CaculatorInterface) Naming.lookup("rmi://localhost/cal03");
            // trieu goi phuong thuc tu xa
            System.out.println(cal.addNum(10, 20));
       
    }
}
