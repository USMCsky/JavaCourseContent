// File: com/tutorialseu/diningphilosophers/DiningPhilosophersProblem.java
package com.tutorialseu.diningphilosophers;

public class DiningPhilosophersProblem {
    public static void main(String[] args) {
        int numberOfPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
        Fork[] forks = new Fork[numberOfPhilosophers];
        Waiter waiter = new Waiter(numberOfPhilosophers);

        // Initialize forks
        for (int i = 0; i < numberOfPhilosophers; i++) {
            forks[i] = new Fork(i);
        }

        // Initialize philosophers and assign forks
        for (int i = 0; i < numberOfPhilosophers; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % numberOfPhilosophers];

            philosophers[i] = new Philosopher(i, leftFork, rightFork, waiter);
            Thread thread = new Thread(philosophers[i], "Philosopher " + i);
            thread.start();
        }
    }
}
