/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMItong2songuyen;

/**
 *
 * @author Admins
 */
// lop the hien trieu goi tu xa
import java.io.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
//Được sử dụng để xuất một đối tượng từ xa với 
//JRMP và lấy một bản gốc giao tiếp với đối tượng từ xa. 
//Stubs được tạo trong thời gian chạy bằng cách sử dụng các 
//đối tượng proxy động hoặc chúng được tạo tĩnh tại thời điểm xây dựng, thường sử dụng rmiccông cụ.
public class Caculator extends UnicastRemoteObject implements CaculatorInterface {
    Caculator() throws RemoteException{
        super();
    }
    
    @Override
    public int addNum(int a, int b) throws RemoteException {
        System.out.println("a Client request ");
        return (a+b);
    }
}
