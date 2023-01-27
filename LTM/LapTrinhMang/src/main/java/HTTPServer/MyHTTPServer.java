/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HTTPServer;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Admins
 */
//• hiển thị địa chỉ của máy khách 
//•gửi lại yêu cầu với mã trạng thái 200 
//• gửi phản hồi đến client 
public class MyHTTPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("MyHTTPServer Started");
        HttpServer server = HttpServer.create(
                new InetSocketAddress(80), 0);
        server.createContext("/index", new IndexHandler());//Phương pháp createcontext liên kết đường dẫn 
        // chỉ mục với một thể hiện của lớp indexhandler. 
        server.start();
    }
    
    static class IndexHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange)
                throws IOException {
            System.out.println(exchange.getRemoteAddress());
            String response = getResponse();
            exchange.sendResponseHeaders(200, response.length());
            OutputStream out = exchange.getResponseBody();
            out.write(response.toString().getBytes());
            out.close();
        }
        public String getResponse() {
            StringBuilder responseBuffer = new StringBuilder();
            responseBuffer
                    .append(
                            "<html><h1>HTTPServer Home Page.... </h1><br>")
                    .append("<b>Welcome to the new and improved web "
                            + "server!</b><BR>")
                    .append("</html>");
            return responseBuffer.toString();
        }
    }
    
    static class DetailHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange)throws IOException {
            Headers requestHeaders = exchange.getRequestHeaders();
            Set<String> keySet = requestHeaders.keySet();
            for (String key : keySet) {
                List values = requestHeaders.get(key);
                String header = key + " = " + values.toString() + "\n";
                System.out.print(header);
            }

        }
    }
    
    
}
