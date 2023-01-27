/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMIobject;

import RMIxulychuoi.*;
import RMItong2songuyen.*;
import RMI.*;
import java.rmi.Remote;

/**
 *
 * @author Admins
 */
//interfeace trieu goi tu xa => throwsException
import java.rmi.*;
public interface CaculatorInterface extends Remote{
    public String xuly(SinhVien sv) throws RemoteException;
    //.... dinh nghia them
}
