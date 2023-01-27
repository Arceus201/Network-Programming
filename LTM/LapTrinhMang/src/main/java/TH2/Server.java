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
import java.net.SocketException;
public class Server {
    public static void main(String[] args) throws SocketException, IOException {
       DatagramSocket server = new DatagramSocket(2207);
       while(true){
           byte [] buf = new byte[1024];
           //nhan
           DatagramPacket dpRes = new DatagramPacket(buf, buf.length);
           server.receive(dpRes);
           String  res = new String(dpRes.getData()).trim();

           System.out.println(res);
           
           //xuly
          
           String s = "123 456";
          
           //gui
           DatagramPacket dpRep = new DatagramPacket(s.getBytes(), s.length(),dpRes.getAddress(),dpRes.getPort());
           server.send(dpRep);
       }
       
    }
}
