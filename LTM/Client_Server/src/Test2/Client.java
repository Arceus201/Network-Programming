/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 *
 * @author Admins
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("TCP client start");
        InetSocketAddress serverAddress = new InetSocketAddress("localhost",6969);
        SocketChannel channel = SocketChannel.open(serverAddress);
    //send arr
        Scanner input = new Scanner(System.in);
        String message = "";
        System.out.print("Send: ");
        message = input.nextLine();
        Control.sendMessage(channel, message);
        
        //receive
        message = Control.receiveMessage(channel);
        System.out.println("Server> " + message);
    }
}
