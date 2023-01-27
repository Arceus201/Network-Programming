/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TH2;

/**
 *
 * @author Admins
 */
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException  {
       DatagramSocket client = new DatagramSocket();
       
       //gui
       String s = "123 abc xyz";
       DatagramPacket dpRes = new DatagramPacket(s.getBytes(), s.length(),InetAddress.getByName("localhost"), 2207);
       client.send(dpRes);
       // nhan
       byte[] buf = new byte[1024];
       DatagramPacket dpRep = new DatagramPacket(buf, buf.length);
       client.receive(dpRep);
        String res = new String(dpRep.getData()).trim();
        String [] words = res.split("\\s");
        int sum =0;
        for (String w : words) {
            sum += Integer.parseInt(w);
        }
        System.out.println(sum);    
        client.close();
        
    }
}
