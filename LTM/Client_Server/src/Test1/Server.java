/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admins
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(220);
        System.out.println("run...");
        while(true){
            Socket conn = server.accept();
            System.out.println(conn);
            //nhan du lieu
            DataInputStream dis = new DataInputStream(conn.getInputStream());
            int a = dis.readInt();
            int b = dis.readInt();
            System.out.format("red(a,b): %d %d\n", a,b);
            
            //gui du lieu
            
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeDouble(a+b);
            
            dis.close();dos.close();conn.close();
        }
    }
    
}
