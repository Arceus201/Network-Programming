/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_Object;

import UDP_String.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Admins
 */
public class Server {
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException {
        DatagramSocket server = new DatagramSocket(2207);
        System.out.println("server runing....");
        while(true){
            byte[] buf = new byte[1024];
            // tiep nha du lieu(ban tin)
            DatagramPacket dpReq = new DatagramPacket(buf, buf.length);
            server.receive(dpReq);
            String strReq = new String(dpReq.getData()).trim();
            System.out.println("Nhan ma bai" + strReq);
            
            
            SinhVien sinhvien = new SinhVien(
                                "NgUYen TRoNg HunG", "04-06-2001");
            //tra, gui ban tin
              if(strReq.equals(";B19DCCN300;UDP_Object")){
                   byte sendData[] = new byte[1024];
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(baos);
                    oos.writeObject(sinhvien );
                    sendData = baos.toByteArray();
                    DatagramPacket dpSend = new DatagramPacket(sendData, sendData.length,
                             dpReq.getAddress(),  dpReq.getPort());
                    server.send(dpSend);
               
               
                    byte receiveData[] = new byte[1024];
                    DatagramPacket dpReceive = new DatagramPacket(receiveData, receiveData.length);
                    server.receive(dpReceive);
                    byte data[] = dpReceive.getData();
                    ByteArrayInputStream bais = new ByteArrayInputStream(data);
                    ObjectInputStream ois = new ObjectInputStream(bais);
                    SinhVien sv = (SinhVien)ois.readObject();
              
                    System.out.println(sv.getName() + " | " + sv.getDateOfBirth());
             

        }
    }
    }
}

//    private static Object StringBuilder(String strReq) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

