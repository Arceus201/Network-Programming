/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.net.MalformedURLException;
import java.rmi.*;
import java.util.ArrayList;
import javax.naming.event.NamingEvent;

/**
 *
 * @author Admin
 */
public class RMIClient {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
       DictionaryManageInterface a = (DictionaryManageInterface) Naming.lookup("rmi://localhost/dictionary");
       
       Dictionary dict1 = new Dictionary("nguyen trong hung","03954394");
       a.addElement(dict1);
       
       ArrayList<Dictionary> list = a.showElement();
       for(Dictionary x: list){
           System.out.println(x.toString());
       }
    }
}
