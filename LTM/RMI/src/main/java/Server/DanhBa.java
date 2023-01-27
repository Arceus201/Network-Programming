/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Server;

/**
 *
 * @author Admins
 */
import java.io.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface DanhBa extends Remote{
    public String getName() throws RemoteException;
    public String getCCCD() throws RemoteException;
    public String getSDT() throws RemoteException;
}
