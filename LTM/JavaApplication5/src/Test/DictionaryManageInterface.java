/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Test;

import java.rmi.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface DictionaryManageInterface extends Remote {
    void addElement(Dictionary dict) throws RemoteException;
    void deleteElement(String name) throws RemoteException;
    ArrayList<Dictionary> showElement() throws RemoteException;
}
