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
import java.net.Socket;

/**
 *
 * @author mam
 */
public class TCPClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket client = new Socket("localhost", 1109);
        System.out.println(client);// check
        //B1: Client gửi thông tin khách hàng cần chuẩn hóa lên Server.
        Customer customer = new Customer(
                        "nguyen VaN hai dUonG", "10-11-2012", "");// Cho phép nhập thông tin từ bàn phím (họ tên, ngày sinh) hoặc Đọc từ file
        
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        oos.writeObject(customer);
        //B4: Nhận khách hàng đã được chuẩn hóa từ server và in ra màn hình
        
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        Customer newCustomer = (Customer) ois.readObject();
        
        System.out.println(newCustomer.getName() + " | " + newCustomer.getDateOfBirth());
        
        
        oos.close();
        ois.close();
        client.close();
        
        // B5: Ghi ra file txt (hoàn thiện)
        
        
    }
}
