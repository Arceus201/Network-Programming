/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package httpproject.client;

import httpproject.controller.Request;
import httpproject.controller.Response;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Client {
    
    public static void main(String args[]) {
        try {
            Socket client = new Socket("localhost", 80);
            System.out.println("Client started");
            ObjectOutputStream request = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream response = new ObjectInputStream(client.getInputStream());
            Scanner input = new Scanner(System.in);
            System.out.print("Nhap phuong thuc (GET/POST/PUT/DELETE/HEAD): ");
            String method = input.nextLine().toUpperCase();
            System.out.print("Nhap ten file: ");
            String target = input.nextLine().toLowerCase();
            System.out.print("Nhap kieu file (html/txt): ");
            String type = input.nextLine().toLowerCase();
            String body = "";
            if (method.equalsIgnoreCase("post") || method.equalsIgnoreCase("put")) {
                System.out.print("Nhap noi dung: ");
                body = input.nextLine();
            }
            Request rq = new Request(method, target, "localhost", body, type);
            request.writeObject(rq);
            System.out.println("Request sended");
            Response rp = (Response)response.readObject();
            System.out.println("Response received\n");
            if (!method.equalsIgnoreCase("head")) {
                System.out.println(rp.responseMessage());
            }
            else {
                System.out.println(rp.responseHeader());
            }
            request.close();
            response.close();
            client.close();
            System.out.println("Client terminated");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
