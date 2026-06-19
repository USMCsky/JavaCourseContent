// File: com/tutorialseu/threadmanagement/TaskRunner.java
package com.tutorialseu.threadmanagement;

public class TaskRunner implements Runnable {
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Task is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Task interrupted");
            }
        }
        System.out.println("Task has stopped.");
    }

    public void stop() {
        running = false;
    }
}
