/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DictionaryManage extends UnicastRemoteObject implements DictionaryManageInterface {

    private ArrayList<Dictionary> listdict = new ArrayList<>();
    
    public DictionaryManage(ArrayList<Dictionary> listdict) throws RemoteException {
        super();
        this.listdict = listdict;
    }
    
    @Override
    public void addElement(Dictionary dict) {
        listdict.add(dict);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admins\\Documents\\NetBeansProjects\\JavaApplication5\\src\\Test\\RMI_test.txt"));
            oos.writeObject(listdict);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void deleteElement(String name) {
        for (int i = 0; i < listdict.size(); i++) {
            if (listdict.get(i).getName().equalsIgnoreCase(name)) {
                listdict.remove(i);
            }
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admins\\Documents\\NetBeansProjects\\JavaApplication5\\src\\Test\\RMI_test.txt"));
            oos.writeObject(listdict);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public ArrayList<Dictionary> showElement() {
        return this.listdict;
    }
    
}
