/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package http;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admins
 */
public class HttpSimpleClient {

    public static void main(String[] args) {
        Socket s;
        try {
            s = new Socket(InetAddress.getByName("localhost"), 8080);
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            String request = "POST " + " HTTP/1.1\r\n"
                    + "User-Agent: HttpSimple/1.0\r\n"
                    + "Accept: text/*\r\n"
                    + "Host: " + "localhost:8080" + "\r\n" + "\r\n";
            out.println(request);
            InputStream in = s.getInputStream();
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                in.read(bytes);
            }
            System.out.println(new String(bytes));
            s.close();
        } catch (Exception ex) {
            Logger.getLogger(HttpSimpleClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

