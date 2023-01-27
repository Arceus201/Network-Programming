/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admins
 */
public class ConsumeProduce {
    public static void main(String[] args) {
        SharedData sd = new SharedData();
        new Producer(sd).start();//extends
        new Thread(new Consumer(sd)).start();//implements
    }
}
class Consumer implements Runnable{
   SharedData sd;
    public Consumer(SharedData sd){
        this.sd = sd;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            try {
                sd.consume();
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

// luong cung cap
class Producer extends Thread{
    SharedData sd;
    public Producer(SharedData sd){
        this.sd = sd;
    }
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            try {
                sd.produce((int)(Math.random()*100));
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class SharedData{
    int data;
    boolean produced = false;
    public synchronized void produce(int data) throws InterruptedException{
        if(produced) 
            this.wait();//(1)
        this.data=data;      
        System.out.println("produce " + data);
        produced = true;
        this.notify();//(2)
    }
    public synchronized void consume() throws InterruptedException{
         if(!produced) 
            this.wait();
        System.out.println("consume" + data);
        this.data=0;
        produced = false;
        this.notify();
    }
    
}