// File: com/tutorialseu/synchronization/CounterWithoutSyncDemo.java
package com.tutorialseu.synchronization;

public class CounterSyncDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Create 1000 threads that increment the counter
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(() -> counter.increment());
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < 1000; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Expected count is 1000
        System.out.println("Final Count (Expected 1000): " + counter.getCount());
    }
}
