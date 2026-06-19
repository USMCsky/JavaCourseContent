// File: com/tutorialseu/concurrency/PrintTask.java
package com.tutorialseu.concurrency;

import java.util.Random;

public class PrintTask implements Runnable {
    private String documentName;

    public PrintTask(String documentName) {
        this.documentName = documentName;
    }

    @Override
    public void run() {
        System.out.println("Printing document: " + documentName + " - Started by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000* (new Random().nextInt(5)+1)); // Simulate time to print
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Printing document: " + documentName + " - Completed by " + Thread.currentThread().getName());
    }
}
