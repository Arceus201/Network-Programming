/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package httpproject.server;

import httpproject.controller.Request;
import httpproject.controller.Response;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

/**
 *
 * @author Admin
 */
public class ClientHandler implements Runnable{
    private Socket client;
            
    public ClientHandler(Socket client) {
        this.client = client;
    }
    
    @Override
    public void run() {
        try {
            ObjectOutputStream request = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream response = new ObjectInputStream(client.getInputStream());
            Request rq = (Request)response.readObject();
            System.out.println("Request received");
            System.out.println(rq.requestMessage());
            System.out.println("Request handling ...");
            if (rq.getMethod().equals("GET")) {
                String file = "C:\\CSDL\\" + rq.getTarget() + "." + rq.getType();
                Response rp = null;
                if (new File(file).exists()) {
                    rp = new Response(200, "OK", getData(file));
                } else {
                    rp = new Response(404, "Not Found");
                }
                request.writeObject(rp);
                System.out.println("Response sended");
            } else if (rq.getMethod().equals("POST")) {
                Response rp = null;
                String file = "C:\\CSDL\\" + rq.getTarget() + "." + rq.getType();
                if (new File(file).exists()) {
                    rp = new Response(403, "Forbidden");
                } else {
                    rp = new Response(200, "OK");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(rq.getBody());
                    writer.close();
                }
                request.writeObject(rp);
            } else if (rq.getMethod().equals("PUT")) {
                Response rp = null;
                String file = "C:\\CSDL\\" + rq.getTarget() + "." + rq.getType();
                if (new File(file).exists()) {
                    rp = new Response(200, "OK");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(rq.getBody());
                    writer.close();
                } else {
                    rp = new Response(404, "Not Found");
                }
                request.writeObject(rp);
            } else if (rq.getMethod().equals("DELETE")) {
                Response rp = null;
                String file = "C:\\CSDL\\" + rq.getTarget() + "." + rq.getType();
                if (new File(file).exists()) {
                    rp = new Response(200, "OK");
                    delete(file);
                } else {
                    rp = new Response(404, "Not Found");
                }
                request.writeObject(rp);
            } else if (rq.getMethod().equals("HEAD")) {
                Response rp = null;
                String file = "C:\\CSDL\\" + rq.getTarget() + "." + rq.getType();
                if (new File(file).exists()) {
                    rp = new Response(200, "OK",getData(file));
                } else {
                    rp = new Response(404, "Not Found");
                }
                request.writeObject(rp);
            }
            response.close();
            request.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } 
    }
    
    private static String getData(String file) {
	File f = new File(file);
	String body = "";
	try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = null;
            while ((line = reader.readLine()) != null) {
                body = body + line + "\n";
            }
            reader.close();
	} catch (IOException ex) {
            ex.printStackTrace();
	}
	return body;
    }
    
    private static void delete(String file) {
        try {
            Files.deleteIfExists(Paths.get(file));
        } catch (NoSuchFileException ex) {
            ex.printStackTrace();
        } catch (DirectoryNotEmptyException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
