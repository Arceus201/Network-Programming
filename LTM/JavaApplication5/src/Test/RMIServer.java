/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class RMIServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException, FileNotFoundException, IOException, ClassNotFoundException {
        LocateRegistry.createRegistry(1099);
        
        
        ArrayList<Dictionary> listdict = new ArrayList<>();
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Admins\\Documents\\NetBeansProjects\\JavaApplication5\\src\\Test\\RMI_test.txt"));
//        listdict = (ArrayList<Dictionary>)ois.readObject();
//        
       for(Dictionary a:listdict){
           System.out.println(a);
       }
        Dictionary Dictionary1 = new Dictionary(
                                "NgUYen TRoNg HunG", "0129192913");
         Dictionary Dictionary2 = new Dictionary(
                                "NgUYen Hai Long", "034838434");
         listdict.add(Dictionary1);
         listdict.add(Dictionary2);
         
         
         byte sendData[] = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admins\\Documents\\NetBeansProjects\\JavaApplication5\\src\\Test\\RMI_test.txt"));
        oos.writeObject(listdict);

        
        Naming.rebind("rmi://localhost/dictionary", new DictionaryManage(listdict));
        System.out.println("Server starting ...");
    }
}
