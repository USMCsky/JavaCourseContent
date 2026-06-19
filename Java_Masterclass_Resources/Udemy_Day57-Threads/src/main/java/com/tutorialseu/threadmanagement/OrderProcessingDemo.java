// File: com/tutorialseu/threadmanagement/OrderProcessingDemo.java
package com.tutorialseu.threadmanagement;

public class OrderProcessingDemo {
    public static void main(String[] args) {
        Thread orderThread = new Thread(new OrderProcessor());
        orderThread.start();

        try {
            Thread.sleep(5000); // Let the order processing run for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Interrupting the order processing thread...");
        orderThread.interrupt();
    }
}
