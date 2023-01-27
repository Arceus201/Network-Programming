/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_Object;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Admins
 */
public class Test {
     public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        DatagramSocket client = new DatagramSocket();
        //gui du lieu(ban tin)
        String strReq = ";B19DCCN300;UDP_Object";
        
        DatagramPacket dpRed = new DatagramPacket(strReq.getBytes(), strReq.length()
                ,InetAddress.getByName("localhost"), 2207);
        client.send(dpRed);
        System.out.println("send success ");
        
        // nhan ket qua ban tin
         byte[] buf = new byte[1024];
        DatagramPacket dpRes= new DatagramPacket(buf, buf.length);
        client.receive(dpRes);
        
         byte [] data = dpRes.getData();
         ByteArrayInputStream in1  = new ByteArrayInputStream(data);
         ObjectInputStream iii = new ObjectInputStream(in1);
         SinhVien sinhvien = (SinhVien) iii.readObject();
         
         
         
        
        
        System.out.println(sinhvien.getName() + " | " + sinhvien.getDateOfBirth());
        
        // xu ly object
        sinhvien.setName(UDP_Object.StrUtils.toNameFirstFormat(sinhvien.getName()));
        sinhvien.setDateOfBirth(UDP_Object.StrUtils.toVNDateFormat(sinhvien.getDateOfBirth()));
        
        
         // tra lai ket qua
         byte [] sendData = new byte[1024];
         ByteArrayOutputStream out1 = new ByteArrayOutputStream();
         ObjectOutputStream jjj = new ObjectOutputStream(out1);
         jjj.writeObject(sinhvien);
         
         sendData = out1.toByteArray();
         
        
        
        DatagramPacket dpSend = new DatagramPacket(sendData, sendData.length, 
                InetAddress.getByName("localhost"), 2207);
        client.send(dpSend);
         
         client.close();
    }
}
