package com.tutorialseu.threadcreation;

public class CountdownThread extends Thread {
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println("Countdown: " + i);
            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException e) {
                System.out.println("Countdown interrupted");
            }
        }
        System.out.println("Liftoff!");
    }
}
