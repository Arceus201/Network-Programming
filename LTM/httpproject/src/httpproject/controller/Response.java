/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package httpproject.controller;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Response implements Serializable{
    private String version = "HTTP/1.1";
    private int statusCode;
    private String statusPhrase;
    private String body = "";

    public Response() {
    }

    public Response(int statusCode, String statusPhrase, String body) {
        this.statusCode = statusCode;
        this.statusPhrase = statusPhrase;
        this.body = body;
    }
    
    public Response(int statusCode, String statusPhrase) {
        this.statusCode = statusCode;
        this.statusPhrase = statusPhrase;
    }

    public String getVersion() {
        return version;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusPhrase() {
        return statusPhrase;
    }

    public void setStatusPhrase(String statusPhrase) {
        this.statusPhrase = statusPhrase;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    public String responseMessage() {
        return version + " " + statusCode + " " + statusPhrase +
                "\nContent-Type: text/html" +
                "\nContent-Length: " + body.length() + "\n\n" +
                body;
    }
    
    public String responseHeader() {
        return version + " " + statusCode + " " + statusPhrase +
                "\nConten t-Type: text/html; charset=utf-8" +
                "\nContent-Length: " + body.length();
    }
}
