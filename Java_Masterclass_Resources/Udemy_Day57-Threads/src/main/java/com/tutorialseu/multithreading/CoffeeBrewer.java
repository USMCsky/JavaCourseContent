// File: com/tutorialseu/multithreading/CoffeeBrewer.java
package com.tutorialseu.multithreading;

public class CoffeeBrewer implements Runnable {
    @Override
    public void run() {
        String[] coffees = {"Espresso", "Latte", "Cappuccino"};
        for (String coffee : coffees) {
            System.out.println("Brewing " + coffee);
            try {
                Thread.sleep(1000); // Simulate time to brew coffee
            } catch (InterruptedException e) {
                System.out.println("Coffee brewing interrupted");
            }
        }
        System.out.println("All coffees are ready!");
    }
}
