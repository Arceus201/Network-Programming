/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object;

/**
 *
 * @author Admins
 */
import java.io.Serializable;

/**
 *
 * @author mam
 */
public class Customer implements Serializable{
    private String name;
    private String dateOfBirth;
    private String userName;

    public Customer(String name, String dateOfBirth, String userName) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.userName = userName;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    
}