/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Admins
 */
import java.io.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
public class Client {
    public static void main(String[] args)  throws NotBoundException, MalformedURLException, RemoteException  {
        try {
           // Registry registry = LocateRegistry.getRegistry("rmi://localhost/RMI",1099);
       
        DanhBa hung = (DanhBa) Naming.lookup("rmi://localhost/RMIh");
        DanhBa dung = (DanhBa) Naming.lookup("rmi://localhost/RMId");
        DanhBa long1 = (DanhBa) Naming.lookup("rmi://localhost/RMIl");
        
        System.out.println("name hung:"+hung.getName());
        System.out.println("cccd hung:"+hung.getCCCD());
        System.out.println("sdt hung:"+hung.getSDT());
        
         System.out.println("---------------------");
        
        System.out.println("name dung:"+dung.getName());
        System.out.println("cccd dung:"+dung.getCCCD());
        System.out.println("sdt dung:"+dung.getSDT());
        
        System.out.println("---------------------");
        
        System.out.println("name long:"+long1.getName());
        System.out.println("cccd long:"+long1.getCCCD());
        System.out.println("sdt long:"+long1.getSDT());
        } catch (Exception e) {
            System.out.print("khong tim thay danh ba");
        }
        
    }
}
