/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_DataStream;

/**
 *
 * @author Admins
 */
import java.io.*;
import java.net.Socket;
public class ClientObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket client = new Socket("localhost",1110);
        
        
       DataOutputStream out = new DataOutputStream(client.getOutputStream());
       out.writeUTF(";B19DCCN300;Object_2");
       
       ObjectInputStream in = new ObjectInputStream(client.getInputStream());
       SinhVien sv = (SinhVien) in.readObject();
       
       System.out.println(sv.getName() + "|" + sv.getDate());
       
       String date = sv.getDate();
       String name = sv.getName();
       
       //date
       String [] w = date.split("-");
       String date2 = w[0]+"|" +w[1]+"|"+w[2];
       System.out.println(date2);
      
       // ten
       String s1 = name.substring(0, name.lastIndexOf(" ")).toLowerCase();
       String s2 = name.substring(name.lastIndexOf(" ")+1,name.length()).toUpperCase();
       System.out.println(s1+"|"+s2);
       
       String[] w2 = s1.split("\\s");
       String s11=",";
       for(String x: w2){
           s11 = s11 + x.substring(0,1).toUpperCase() + x.substring(1,x.length()).toLowerCase();
           s11=s11+" ";
       }
       s11=s11.substring(0,s11.length()-1);
       
       
       ObjectOutputStream out2 = new ObjectOutputStream(client.getOutputStream());
       sv.setName(s2+s11);
       sv.setDate(date2);
      
       out2.writeObject(sv);
       
       client.close();
       out.close();
       in.close();
    }
   
}
