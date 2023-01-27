/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FreePastry;

/**
 *
 * @author Admins
 */
public class FreePastryApplication implements Application {
    protected Endpoint endpoint;
    private final String message;
    private final String instance = " Instance ID";

    public FreePastryApplication(Node node) {
        this.endpoint = node.buildEndpoint(this, instance);
        this.message = "Hello there! from Instance: "
                + instance + " Sent at: [" + getCurrentTime()
                + "]";
        this.endpoint.register();
    }
    
    private long getCurrentTime() {
        return this.endpoint
                .getEnvironment()
                .getTimeSource()
                .currentTimeMillis();
    }
    
    public void routeMessage(Id id) {
        System.out.println(
                "Message Sent\n\tCurrent Node: "
                + this.endpoint.getId()
                + "\n\tDestination: " + id
                + "\n\tTime: " + getCurrentTime());
        Message msg = new PastryMessage(endpoint.getId(),
                id, message);
        endpoint.route(id, msg, null);
    }
    
    public void deliver(Id id, Message message) {
        System.out.println("Message Received\n\tCurrent Node: "
                + this.endpoint.getId() + "\n\tMessage: "
                + message + "\n\tTime: " + getCurrentTime());
    }
}
