
import vn.medianew.Caculotor;
import vn.medianew.Caculotor_Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admins
 */
public class Client {
    public static void main(String[] args) {
         Caculotor_Service service = new vn.medianew.Caculotor_Service();
         Caculotor port = service.getCaculotorPort();
        System.out.print(port.add(100, 200));
    }
}
