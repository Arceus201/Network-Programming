/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatastreamBuffer;

import DataStream.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
            BufferedReader dis = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String ma = dis.readLine();
            System.out.println("Ma bai:"+ ma);
           
           // gui  du lieu _ string
           if(ma.equals(";B19DCCN300;002")){
               DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
                dos.writeBytes("abc Hbd HNK"+'\n');
           
           // in ra chuoi sau xu ly
               BufferedReader result = new BufferedReader(new InputStreamReader(conn.getInputStream()));
               String s =result.readLine();
                System.out.println(s);
                dos.close();
           }
           // dong ket noi
           dis.close();
           conn.close();
        }
                
    }
}
