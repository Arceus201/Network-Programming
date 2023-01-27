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
import RMItong2songuyen.*;
import RMI.*;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class CaculatorServer {

    public static void main(String[] args) throws AlreadyBoundException, RemoteException, MalformedURLException {
        //xem con bat hay tat
        LocateRegistry.createRegistry(1099);
        //tao doi tuong Caculator
        Caculator cal = new Caculator();
        System.out.println("Exporting Calculator ! ");
        //thong bao su hien dien của cal la doi tuong co kha nang remote cho JVM

        //dang ky doi tuong voi trinh quan ly rmi
        Naming.rebind("rmi://localhost/B3B19DCCN300", cal);
        System.out.println("Success");

    }

}
