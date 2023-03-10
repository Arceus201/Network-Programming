/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_server;

/**
 *
 * @author Admins
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoChatSingleServer {
    public final static int SERVER_PORT = 7;

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("Server started: " + serverSocket);
			System.out.println("Waiting for a client ...");
			while (true) {
				try {
					Socket socket = serverSocket.accept();
					System.out.println("Client accepted: " + socket);

					OutputStream os = socket.getOutputStream();
					InputStream is = socket.getInputStream();
					int ch = 0;
					while (true) {
						ch = is.read(); // Receive data from client
						if (ch == -1) {
							break;
						}
						os.write(ch); // Send the results to client
					}
					socket.close();
				} catch (IOException e) {
					System.err.println(" Connection Error: " + e);
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (serverSocket != null) {
				serverSocket.close();
			}
		}
	}
}
