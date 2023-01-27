/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_DataStream;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admins
 */
public class Server {
     public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(1110);
        System.out.println("server is running ...");
        while(true){
            Socket conn = server.accept();
            
            // B1: nhan ma bai
             DataInputStream dis = new DataInputStream(conn.getInputStream());
            String ma = dis.readUTF();
            System.out.println("Ma bai:"+ ma);
            
            // neu ma bai giong => tra ve object 
            if(ma.equals(";B19DCCN300;Object_2")){
                //B2: gui object sinh viên cho client.
                SinhVien sinhvien = new SinhVien(
                                "NgUYen TRoNg HunG", "04-06-2001");

                ObjectOutputStream oos = new ObjectOutputStream(conn.getOutputStream());
                oos.writeObject(sinhvien);
                
                
                //B3: Nhận khách hàng đã được chuẩn hóa từ server và in ra màn hình
        
                ObjectInputStream ois = new ObjectInputStream(conn.getInputStream());
                SinhVien newSinhVien = (SinhVien) ois.readObject();

                System.out.println(newSinhVien.getName() + " | " + newSinhVien.getDate());
                
                ois.close();
                oos.close();
           }
            
            conn.close();
            
            // B5': Ghi vào file .txt
            
        }
    }
}
