/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMIobject;

/**
 *
 * @author Admins
 */
// lop the hien trieu goi tu xa
import RMIxulychuoi.*;
import RMItong2songuyen.*;
import java.io.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
//Được sử dụng để xuất một đối tượng từ xa với 
//JRMP và lấy một bản gốc giao tiếp với đối tượng từ xa. 
//Stubs được tạo trong thời gian chạy bằng cách sử dụng các 
//đối tượng proxy động hoặc chúng được tạo tĩnh tại thời điểm xây dựng, thường sử dụng rmiccông cụ.
public class Caculator extends UnicastRemoteObject implements CaculatorInterface {
    Caculator() throws RemoteException{
        super();
    }

  
    

    @Override
    public String xuly(SinhVien sv) throws RemoteException {
       return String.format(" %s  %s %.1f",sv.getHoten(),new SimpleDateFormat("dd/mm/yyyy").format(sv.getNs()),(sv.getDiem1()+sv.getDiem2()+sv.getDiem3()) );
    }
    
    

    
   
}
