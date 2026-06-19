package com.tutorialseu.threadcreation;

public class ServerStatusChecker implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Checking server status...");
            // Simulate checking server status
            try {
                Thread.sleep(2000); // Pause for 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Status check interrupted");
            }
        }
        System.out.println("Server status check complete.");
    }
}
