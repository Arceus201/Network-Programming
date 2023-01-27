/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

/**
 *
 * @author Admins
 */
import java.io.*;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class Server {
    public static void main(String[] args)  throws AlreadyBoundException, RemoteException, MalformedURLException {
        try {
            LocateRegistry.createRegistry(1099);
//            System.setProperty("rmi://localhost/RMI", "127.0.0.1");
            
            DanhBampl p1 = new DanhBampl("hung", "0949349349", "034934934");
            DanhBampl p2 = new DanhBampl("dung", "0343485855", "0405945848");
            DanhBampl p3 = new DanhBampl("long", "0485485885", "0345834583");
            
            
//            DanhBa stub1 = (DanhBa) UnicastRemoteObject.exportObject(p1, 0);
//            DanhBa stub2 = (DanhBa) UnicastRemoteObject.exportObject(p2, 0);
//            DanhBa stub3 = (DanhBa) UnicastRemoteObject.exportObject(p3, 0);
//            
//            Registry registry = LocateRegistry.getRegistry("127.0.0.1",9100);
            
             Naming.rebind("rmi://localhost/RMIh",p1);
             Naming.rebind("rmi://localhost/RMId",p2);
             Naming.rebind("rmi://localhost/RMIl",p3);
            
            System.out.println("suscess..");
        } catch (Exception e) {
            System.out.println("DangKy false");
        }
    }
}
