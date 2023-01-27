/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NIC_MTC;

/**
 *
 * @author Admins
 */
import java.io.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
public class MulticastClient {
    public static void main(String[] args) throws IOException {
        MulticastSocket client = new MulticastSocket(2209);
        client.joinGroup(InetAddress.getByName("224.2.2.3"));
        System.out.println("join success");
        while(true){
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            client.receive(dp);
            System.out.println(new String(dp.getData()).trim());
                    
        }
    }
}
