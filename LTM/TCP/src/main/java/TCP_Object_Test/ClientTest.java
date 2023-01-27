/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object_Test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Admins
 */
public class ClientTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket client = new Socket("localhost", 1109);
        System.out.println(client);// check
        
        // B1: gui len MSV + ma de
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(";B19DCCN300;Object_2");
        
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        SinhVien sinhvien = (SinhVien) ois.readObject();
        
        
            
        
         // xử lý chuẩn hóa
        sinhvien.setName(TCP_Object.StrUtils.toNameFirstFormat(sinhvien.getName()));
        sinhvien.setDateOfBirth(TCP_Object.StrUtils.toVNDateFormat(sinhvien.getDateOfBirth()));
//        customer.setUserName(TCP_Object.StrUtils.toShortNameFormat(customer.getName()));
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        // gửi về cho client
        oos.writeObject(sinhvien);
        
        
        oos.close();
        ois.close();
        client.close();
        
        // B5: Ghi ra file txt (hoàn thiện)
        
        
    }
}
