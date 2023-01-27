/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Admins
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client  = new Socket("localhost",220);
        System.out.println(client);
        // gui nhan du lieu tuan theo http
        //gui du lieu
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeInt(100);
        dos.writeInt(200);
        
        // nhan du lieu
        DataInputStream dis = new DataInputStream(client.getInputStream());
        double sum = dis.readDouble();
        System.out.println("sum "+sum);
        
        
        dos.close();
    }
}
