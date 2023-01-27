/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 *
 * @author Admins
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("TCP server....");
        InetSocketAddress add = new InetSocketAddress(6969);
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(add);
        
        
        SocketChannel channel = server.accept();
        //receive
        String message = "";
        message =  Control.receiveMessage(channel);
        
        System.out.println("Client> "+message);
        
        //send back message after process
        //uppercaseMessage(channel, message);
        reverseMessage(channel, message);
        System.out.println("Done.");
    }
    public static void uppercaseMessage(SocketChannel channel,String message) throws IOException{
        String newMessage = message.toUpperCase();
        Control.sendMessage(channel, newMessage);
    }
    //dao nguoc chuoi
    public static void reverseMessage(SocketChannel channel,String message) throws IOException{
        String newMessage = "";
        for(int i=message.length()-1;i>=0;i--){
            newMessage += message.charAt(i);  
        }
         Control.sendMessage(channel, newMessage);
    }
}
