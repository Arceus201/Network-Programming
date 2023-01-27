/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package webservice;

import vn.medianew.Caculotor;
import vn.medianew.Caculotor_Service;

/**
 *
 * @author Admins
 */
public class WebService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Caculotor_Service service = new vn.medianew.Caculotor_Service();
        Caculotor port = service.getCaculotorPort();
        System.out.println(port.add(100, 200));
    }

    
    
}
