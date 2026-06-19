// File: com/tutorialseu/threadmanagement/OrderProcessor.java
package com.tutorialseu.threadmanagement;

public class OrderProcessor implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Processing order #" + i);
                Thread.sleep(1000); // Simulate time to process an order
            }
        } catch (InterruptedException e) {
            System.out.println("Order processing was interrupted");
        }
        System.out.println("Order processing thread exiting");
    }
}
