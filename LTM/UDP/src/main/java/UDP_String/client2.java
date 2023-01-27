/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_String;

/**
 *
 * @author Admins
 */
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
public class client2 {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        
        String s = ";B19DCCN300;201";
        
        DatagramPacket out = new DatagramPacket(s.getBytes(), s.length(),
                InetAddress.getByName("localhost"), 2207);
        client.send(out);
        
        byte [] buf = new byte[1024];
        DatagramPacket in =  new DatagramPacket(buf, buf.length);
        client.receive(in);
        
        String s1 = new String(in.getData()).trim();
        
        
        // xu ly
        String s2 = "";
        String [] w = s1.split("\\s");
        for(String x: w){
            s2 = s2+ x.substring(0,1).toUpperCase() + x.substring(1,x.length()).toLowerCase();
            s2 = s2+" ";
        }
        s2 = s2.substring(0,s2.length()-1);
        
        DatagramPacket out2 = new DatagramPacket(s2.getBytes(), s2.length(),
                InetAddress.getByName("localhost"), 2207);
        client.send(out2);
        
        
    }
           
}
