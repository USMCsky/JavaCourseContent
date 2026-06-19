// File: com/tutorialseu/threadcommunication/Consumer.java
package com.tutorialseu.threadcommunication;

public class Consumer implements Runnable {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                resource.consume();
                Thread.sleep(1000); // Simulate time to consume
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
