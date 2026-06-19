// File: com/tutorialseu/threadcommunication/ProducerConsumerDemo.java
package com.tutorialseu.threadcommunication;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}
