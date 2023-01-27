/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Dictionary implements Serializable { 
    
    private String name;
    private String phonenumber;

    public Dictionary() {
    }

    public Dictionary(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    public Object toObject() {
        return new Object[] {
            name, phonenumber
        };
    }
    
    public String toString() {
        return name + ": " + phonenumber;
    }
}
