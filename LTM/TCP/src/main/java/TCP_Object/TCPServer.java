/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object;

/**
 *
 * @author Admins
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author mam
 */
public class TCPServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(1109);
        System.out.println("server is running ...");
        while(true){
            Socket conn = server.accept();
            //B2: Server tiếp nhận, xử lý chuẩn hóa dữ liệu
            ObjectInputStream ois = new ObjectInputStream(conn.getInputStream());
            Customer customer = (Customer) ois.readObject();
            System.out.println(customer.getName() + " | " + customer.getDateOfBirth());

            //B3: Server trả kết quả về cho client.
            ObjectOutputStream oos = new ObjectOutputStream(conn.getOutputStream());
            // xử lý chuẩn hóa
            customer.setName(StrUtils.toNameFirstFormat(customer.getName()));
            customer.setDateOfBirth(StrUtils.toVNDateFormat(customer.getDateOfBirth()));
            customer.setUserName(StrUtils.toShortNameFormat(customer.getName()));
            // gửi về cho client
            oos.writeObject(customer);
            
            ois.close();
            oos.close();
            conn.close();
            
            // B5': Ghi vào file .txt
            
        }
    }
}