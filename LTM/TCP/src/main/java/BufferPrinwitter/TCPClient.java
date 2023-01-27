/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BufferPrinwitter;

/**
 *
 * @author Admins
 */
import java.io.*;
import java.net.*;

/**
 * Usage:input a string, server will return a value.
**/

class TCPClient {
   public static void main(String[] args) throws IOException {
        Socket client  = new Socket("localhost",2207);
       
        // gui nhan du lieu tuan theo http
        //gui du lieu
       PrintWriter dos = new PrintWriter(client.getOutputStream(), true);
        dos.println(";B19DCCN300;002"+'\n');
        
       
        // nhan du lieu
        BufferedReader dis = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String s = dis.readLine();
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
         PrintWriter result = new PrintWriter(client.getOutputStream(), true);
        result.println(";002;"+s2+'\n');
        
        
        dos.close();   
    }
}
