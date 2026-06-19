// File: com/tutorialseu/multithreading/SandwichMaker.java
package com.tutorialseu.multithreading;

public class SandwichMaker implements Runnable {
    @Override
    public void run() {
        String[] sandwiches = {"Ham Sandwich", "Cheese Sandwich", "Veggie Sandwich"};
        for (String sandwich : sandwiches) {
            System.out.println("Making " + sandwich);
            try {
                Thread.sleep(1500); // Simulate time to make a sandwich
            } catch (InterruptedException e) {
                System.out.println("Sandwich making interrupted");
            }
        }
        System.out.println("All sandwiches are ready!");
    }
}
