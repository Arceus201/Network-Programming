
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admins
 */
public class TCPServer_Buffer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(2207);
        System.out.println("run.....");
        while(true){
           Socket conn = server.accept();
            System.out.println(conn);
           // nhan du lieu thong tin Ma bai
            BufferedReader dis = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String ma = dis.readLine();
            System.out.println("Ma bai:"+ ma);
           
           // gui  du lieu _ string
           if(ma.equals(";B19DCCN300;001")){
                 BufferedWriter dos = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
                dos.write("abc Hbd HNK");
                dos.flush();
                
           
           // in ra chuoi sau xu ly
                BufferedReader dis2 = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String tmp = dis2.readLine();
                System.out.println(tmp);
                dos.close();
           }
           // dong ket noi
           dis.close();
           conn.close();
        }         
    }
}
