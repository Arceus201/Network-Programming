/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMIxulychuoi;

/**
 *
 * @author Admins
 */
// lop the hien trieu goi tu xa
import RMItong2songuyen.*;
import RMI.*;
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
    public String xuly(String s) throws RemoteException {
        String [] words = s.split("\\s");
        String s2 = "";
        for(String w : words){
            w = w.substring(0,1).toUpperCase() + w.substring(1,w.length()).toLowerCase();
            s2 = s2+w+" ";
        }
        
        return s2;
    }
}
