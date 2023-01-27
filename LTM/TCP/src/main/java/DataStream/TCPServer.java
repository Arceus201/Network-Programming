/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admins
 */
public class TCPServer {
     public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(2207);
        System.out.println("run.....");
        while(true){
           Socket conn = server.accept();
            System.out.println(conn);
           // nhan du lieu thong tin Ma bai
            DataInputStream dis = new DataInputStream(conn.getInputStream());
            String ma = dis.readUTF();
            System.out.println("Ma bai:"+ ma);
           
           // gui  du lieu _ string
           if(ma.equals(";B19DCCN300;001")){
                DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
                dos.writeUTF("abc Hbd HNK");
           
           // in ra chuoi sau xu ly
                DataInputStream result = new DataInputStream(conn.getInputStream());
                String tmp = result.readUTF();
                System.out.println(tmp);
                dos.close();
           }
           // dong ket noi
           dis.close();
           conn.close();
        }
                
    }
}
