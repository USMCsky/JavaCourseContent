// File: com/tutorialseu/threadcommunication/Producer.java
package com.tutorialseu.threadcommunication;

public class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) {
            try {
                resource.produce(value);
                value++;
                Thread.sleep(500); // Simulate time to produce
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
