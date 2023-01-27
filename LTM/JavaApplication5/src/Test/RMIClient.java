/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.net.MalformedURLException;
import java.rmi.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class RMIClient {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        System.out.println("Client starting ...");
        DictionaryManageInterface dmi = (DictionaryManageInterface)Naming.lookup("rmi://localhost/dictionary");
        
        Dictionary Dictionary1 = new Dictionary(
                                "NgUYen van A", "03473456848");
        Dictionary Dictionary2 = new Dictionary(
                                "NgUYen van B", "03483488338");
        dmi.addElement(Dictionary1);
        //dmi.deleteElement("NgUYen van A");
        dmi.addElement(Dictionary2);
        
        ArrayList<Dictionary> listdict = dmi.showElement();
        for (Dictionary dict: listdict) {
            System.out.println(dict.toString());
        } 
    }
}
