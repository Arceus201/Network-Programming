/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admins
 */
import java.io.*;
import java.net.Socket;

public class Test3 {
    public static void main(String[] args) throws IOException {
        Socket client  = new Socket("localhost",2207);
        
        
        DataOutputStream out =  new DataOutputStream(client.getOutputStream());
        out.writeUTF("");
        
        DataInputStream in = new DataInputStream(client.getInputStream());
        String s =   in.readUTF();
        
        String [] w = s.split("\\s");
        String s2="";
        for(String x: w){
            s2 = s2+ x.substring(0,1).toUpperCase() + x.substring(1,x.length());
            s2 = s2+" ";
        }
        s2 = s2.substring(0,s2.length()-1);
        
         DataOutputStream out2 =  new DataOutputStream(client.getOutputStream());
        out2.writeUTF(s2);
        
        
    }
}
