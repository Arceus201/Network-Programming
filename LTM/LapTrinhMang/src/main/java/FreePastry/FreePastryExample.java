/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FreePastry;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 *
 * @author Admins
 */
public class FreePastryExample {
    public static void main(String[] args) throws Exception {
        Environment environment = new Environment();//Lớp này giữ các cài đặt tham số cho nút
        environment.getParameters().setString("nat_search_policy", "never");// chính sách tìm kiếm nat được đặt thành không bao giờ, 
        //cho phép chúng ta sử dụng chương trình trong một lan địa phương mà không khó khăn
        try {
            int bindPort = 9001;
            int bootPort = 9001;
            InetAddress bootInetAddress = InetAddress.getByName("192.168.1.14");
            InetSocketAddress bootAddress = new InetSocketAddress(bootInetAddress, bootPort);
            System.out.println("InetAddress: " + bootInetAddress);
            FreePastryExample freePastryExample = new FreePastryExample(bindPort, bootAddress, environment);
        } catch (Exception e) {
// Handle exceptions
        }

    }
    
    public FreePastryExample(int bindPort,InetSocketAddress bootAddress,Environment environment) throws Exception {
        NodeIdFactory nidFactory = new RandomNodeIdFactory(environment);
        PastryNodeFactory factory = new SocketPastryNodeFactory(nidFactory, bindPort, environment);
        PastryNode node = factory.newNode();

        FreePastryApplication application= new FreePastryApplication(node);
        node.boot(bootAddress);
        System.out.println("Node " + node.getId().toString()+ " created");
        environment.getTimeSource().sleep(10000);
        Id randomId = nidFactory.generateNodeId();
        application.routeMessage(randomId);

    }
}
