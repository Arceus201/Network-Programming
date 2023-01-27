/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_DataStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Admins
 */
public class CientString {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 2207);
        
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        out.writeUTF(";B19DCCN300;001");
        
        DataInputStream in = new DataInputStream(client.getInputStream());
        String s = in.readUTF();
        
        String s2="";
        String [] word = s.split("\\s");
        for( String x: word){
            s2 = s2+x.substring(0,1).toUpperCase() + x.substring(1,x.length()).toLowerCase();
            s2=s2+" ";
            
        }
        s2 = s2.substring(0,s2.length()-1);
         DataOutputStream out2= new DataOutputStream(client.getOutputStream());
        out2.writeUTF(";001;"+s2);
    }
        
    
}
