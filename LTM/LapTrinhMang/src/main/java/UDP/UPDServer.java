/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.*;

/**
 *
 * @author Admins
 */
public class UPDServer {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(2207);
        System.out.println("server runing....");
        while(true){
            byte[] buf = new byte[1024];
            // tiep nha du lieu(ban tin)
            DatagramPacket dpReq = new DatagramPacket(buf, buf.length);
            server.receive(dpReq);
            String strReq = new String(dpReq.getData()).trim();
            System.out.println(strReq);
            
            //xu ly
           // String strRes = StrUtils.Reverse(strReq);
            String strRes = new StringBuilder(strReq).reverse().toString();
//           ReverseString strRes = new ReverseString(strReq);
//           strRes.reverse();
            //tra, gui ban tin
             DatagramPacket dpRes = new DatagramPacket(strRes.getBytes(), strRes.length()
            ,dpReq.getAddress(),dpReq.getPort());
            server.send(dpRes);
;
        }
    }

    private static Object StringBuilder(String strReq) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
