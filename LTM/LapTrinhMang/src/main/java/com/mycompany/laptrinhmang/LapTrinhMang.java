/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.laptrinhmang;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admins
 */
public class LapTrinhMang {

    public static void main(String[] args) { 
        
        String file = "C:\\Users\\Admins\\Desktop\\2022-2023 1\\Lập trình mạng\\tuần 1\\ex1.txt";
        try(FileInputStream fis = new FileInputStream(file)){
            byte[] data = new byte[1024];
            while(fis.available()>0){
                fis.read(data);
                System.out.println(new String(data,"utf-8"));
            }
        }catch(Exception e){
            System.out.println(e.getCause());
        }
//        FileInputStream fis = new FileInputStream("C:\\Users\\Admins\\Desktop\\2022-2023 1\\Lập trình mạng\\tuần 1\\ex1.txt");
//            byte[] data = new byte[128];
//            int i = fis.read(data);
//            while(i!=-1)
//            {
//                System.out.print(new String(data,0,i,"utf-8"));
//                i = fis.read(data);
//            }

    }
}
