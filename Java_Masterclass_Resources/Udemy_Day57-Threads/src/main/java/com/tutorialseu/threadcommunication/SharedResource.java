// File: com/tutorialseu/threadcommunication/SharedResource.java
package com.tutorialseu.threadcommunication;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 5;

    public void produce(int value) throws InterruptedException {
        synchronized (this) {
            while (queue.size() == CAPACITY) {
                System.out.println("Queue is full. Producer is waiting.");
                wait(); // Release the lock and wait
            }
            queue.add(value);
            System.out.println("Produced: " + value);
            notify(); // Notify the consumer
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            while (queue.isEmpty()) {
                System.out.println("Queue is empty. Consumer is waiting.");
                wait(); // Release the lock and wait
            }
            int value = queue.remove();
            System.out.println("Consumed: " + value);
            notify(); // Notify the producer
        }
    }
}
