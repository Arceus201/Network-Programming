/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NIC_MTC;

/**
 *
 * @author Admins
 */
import com.sun.nio.sctp.PeerAddressChangeNotification;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
public class MulticastServer {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, InterruptedException {
        DatagramSocket ds = new DatagramSocket();
        System.out.println("Server start");
        int i=0;
        while(true){
            String strMessage = "message" + i;
            DatagramPacket dp = new DatagramPacket(strMessage.getBytes(), strMessage.length()
            ,InetAddress.getByName("224.2.2.3"),2209);
            Thread.sleep(2000);
            ds.send(dp);
            i++;
        }
    }
}
