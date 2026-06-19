// File: com/tutorialseu/diningphilosophers/Philosopher.java
package com.tutorialseu.diningphilosophers;

public class Philosopher implements Runnable {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;

    private final Waiter waiter;

    public Philosopher(int id, Fork leftFork, Fork rightFork, Waiter waiter) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;

        this.waiter = waiter;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking.");
        Thread.sleep(500);
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating.");
        Thread.sleep(500);
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();

                waiter.requestPermission(id);

                synchronized (leftFork) {
                    System.out.println("Philosopher " + id + " picked up left fork " + leftFork.getId());
                    synchronized (rightFork) {
                        System.out.println("Philosopher " + id + " picked up right fork " + rightFork.getId());
                        eat();
                        System.out.println("Philosopher " + id + " put down right fork " + rightFork.getId());
                    }
                    System.out.println("Philosopher " + id + " put down left fork " + leftFork.getId());
                }

                waiter.releasePermission(id);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
