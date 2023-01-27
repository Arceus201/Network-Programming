/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Admins
 */

public class TCPClient_String {
     public static void main(String[] args) throws IOException {
        Socket client  = new Socket("localhost",2207);
       
        // gui nhan du lieu tuan theo http
        //B1:gui du lieu
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(";B19DCCN300;001");
        
        
        // nhan du lieu
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String s = dis.readUTF();
        System.out.println("nhan ve :" +s);
        
        //xu ly chuan hoa chuoi
        String s2 = "";
        String [] words = s.split("\\s") ;
        for( String x: words){
            s2 = s2 + x.substring(0, 1).toUpperCase() + x.substring(1, x.length()).toLowerCase();
            s2 = s2 + " ";
        }
        // bo " " cuoi cung
        s2 = s2.substring(0, s2.length()-1);
        System.out.println("ket qua: " + s2);
        
        // gui chuoi sau chuan hoa len server
        DataOutputStream result = new DataOutputStream(client.getOutputStream());
        result.writeUTF(";001;"+s2);
        
        
        dos.close();   
    }
}
