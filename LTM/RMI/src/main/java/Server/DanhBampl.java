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
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
//extends UnicastRemoteObject
public class DanhBampl extends UnicastRemoteObject implements DanhBa{
    DanhBampl() throws RemoteException{
        super();
    }
    public String name;
    public String cccd;
    public String sdt;
    
    public  DanhBampl(String name, String cccd, String sdt)throws RemoteException {
        this.name = name;
        this.cccd = cccd;
        this.sdt = sdt;
    } 

    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    @Override
    public String getCCCD() throws RemoteException {
        return this.cccd;
    }

    @Override
    public String getSDT() throws RemoteException {
        return this.sdt;
    }
    
}
