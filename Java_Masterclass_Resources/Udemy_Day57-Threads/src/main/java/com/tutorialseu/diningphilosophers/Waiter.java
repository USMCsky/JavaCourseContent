// File: com/tutorialseu/diningphilosophers/Waiter.java
package com.tutorialseu.diningphilosophers;

public class Waiter {
    private final int maxPhilosophers;
    private int philosophersEating = 0;

    public Waiter(int maxPhilosophers) {
        this.maxPhilosophers = maxPhilosophers - 1; // Allow maxPhilosophers - 1 philosophers to eat
    }

    public synchronized void requestPermission(int philosopherId) throws InterruptedException {
        while (philosophersEating >= maxPhilosophers) {
            wait();
        }
        philosophersEating++;
        System.out.println("Waiter grants permission to Philosopher " + philosopherId);
    }

    public synchronized void releasePermission(int philosopherId) {
        philosophersEating--;
        System.out.println("Philosopher " + philosopherId + " notifies waiter about finishing eating");
        notifyAll();
    }
}
