/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package httpproject.server;

import httpproject.controller.Request;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Admin
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(80);
            System.out.println("Server started");
            ExecutorService executor = Executors.newFixedThreadPool(10);
            while (true) {
                Socket client = server.accept();
                System.out.println("Connection made with: " + client.getInetAddress() + " client");
                executor.execute(new ClientHandler(client));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } /*catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }*/
    }
}
