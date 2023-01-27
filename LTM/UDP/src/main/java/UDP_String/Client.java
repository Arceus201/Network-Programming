/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_String;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Admins
 */
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        //gui du lieu(ban tin)
        String strReq = ";B19DCCN300;201";
        
        DatagramPacket dpRed = new DatagramPacket(strReq.getBytes(), strReq.length()
                ,InetAddress.getByName("localhost"), 2207);
        client.send(dpRed);
        System.out.println("send success ");
        
        // nhan ket qua ban tin
         byte[] buf = new byte[1024];
        DatagramPacket dpRes= new DatagramPacket(buf, buf.length);
        client.receive(dpRes);
         String s = new String(dpRes.getData()).trim();
         System.out.println(s);
         //  xu ly
         String s2 = "";
          String [] words = s.split("\\s") ;
        for( String x: words){
            s2 = s2 + x.substring(0, 1).toUpperCase() + x.substring(1, x.length()).toLowerCase();
            s2 = s2 + " ";
        }
        // bo " " cuoi cung
        s2 = s2.substring(0, s2.length()-1);
        System.out.println("ket qua: " + s2);
        
         // tra lai ket qua
         DatagramPacket dpRed2 = new DatagramPacket(s2.getBytes(), s2.length()
                ,InetAddress.getByName("localhost"), 2207);
        client.send(dpRed2);
         
         client.close();
    }
}
