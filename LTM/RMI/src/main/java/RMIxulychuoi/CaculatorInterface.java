/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMIxulychuoi;

import RMItong2songuyen.*;
import java.io.*;
import java.rmi.Remote;

/**
 *
 * @author Admins
 */
//interfeace trieu goi tu xa => throwsException
import java.rmi.*;
public interface CaculatorInterface extends Remote{
    public String xuly(String s) throws RemoteException;
    //.... dinh nghia them
}
