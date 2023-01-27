


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

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
public class UDPClient {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        //gui du lieu(ban tin)
        String strReq = "abc xyz 123";
        
        DatagramPacket dpRed = new DatagramPacket(strReq.getBytes(), strReq.length()
                ,InetAddress.getByName("localhost"), 2207);
        client.send(dpRed);
        System.out.println("send success ");
        // nhan ket qua ban tin
         byte[] buf = new byte[1024];
        DatagramPacket dpRes= new DatagramPacket(buf, buf.length);
        client.receive(dpRes);
         System.out.println(new String(dpRes.getData()).trim());
         
         client.close();
    }
}
