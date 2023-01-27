/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_String;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Admins
 */
public class Server {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(2207);
        System.out.println("server runing....");
        while(true){
            byte[] buf = new byte[1024];
            // tiep nha du lieu(ban tin)
            DatagramPacket dpReq = new DatagramPacket(buf, buf.length);
            server.receive(dpReq);
            String strReq = new String(dpReq.getData()).trim();
            System.out.println("Nhan ma bai" + strReq);
            
            
            String strRes = "abc ABC ABcd";
            //tra, gui ban tin
              if(strReq.equals(";B19DCCN300;201")){
                    DatagramPacket dpRes = new DatagramPacket(strRes.getBytes(), strRes.length()
                   ,dpReq.getAddress(),dpReq.getPort());
                   server.send(dpRes);
               
               
                        byte[] buf2 = new byte[1024];
                      DatagramPacket dpReq2 = new DatagramPacket(buf2, buf2.length);
                     server.receive(dpReq2);
                     String strReq2 = new String(dpReq2.getData()).trim();
                     System.out.println("Nhan chuoi sau " + strReq2);
              }
              
             
;
        }
    }

//    private static Object StringBuilder(String strReq) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
