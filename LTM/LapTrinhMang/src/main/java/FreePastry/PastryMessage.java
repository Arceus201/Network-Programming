/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FreePastry;

import javax.annotation.processing.Messager;

/**
 *
 * @author Admins
 */
public class PastryMessage implements Messageragerage{
    private final Id from;
    private final Id to;
    private final String messageBody;

    public PastryMessage(Id from, Id to, String messageBody) {
        this.from = from;
        this.to = to;
        this.messageBody = messageBody;
    }
    
    public int getPriority() {
        return Message.LOW_PRIORITY;
    }
    
    public String toString() {
        return "From: " + this.from
                + " To: " + this.to
                + " [" + this.messageBody + "]";
    }
}
