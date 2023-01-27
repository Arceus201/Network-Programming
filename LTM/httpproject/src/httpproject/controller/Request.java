/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Request-line = Phương thức + URI–Request + Phiên bản HTTP
package httpproject.controller;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Request implements Serializable{
    private String method;
    private String target;
    private String version = "HTTP/1.1";
    private String host;
    private String body;
    private String type;

    public Request(String method, String target, String host, String body, String type) {
        this.method = method;
        this.target = target;
        this.host = host;
        this.body = body;
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getVersion() {
        return version;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String requestMessage(){
        return method + " /" + target + " " + version +
                "\nHost: " + host +
                "\nUser-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0\n\n" + 
                "\nAccept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8" +
                "\nAccept-Language: en-US,en;q=0.5" + 
                "\nAccept-Encoding: gzip, deflate, br" + 
                "\nReferer: https://developer.mozilla.org/testpage.html" + 
                "\nConnection: keep-alive" + 
                "\nUpgrade-Insecure-Requests: 1" + 
                "\nContent-Type: text/html" +
                "\nContent-Length: " + body.length() + "\n\n" + 
                body;
    }
}
