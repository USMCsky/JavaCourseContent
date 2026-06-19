// File: com/tutorialseu/multithreading/KitchenSimulation.java
package com.tutorialseu.multithreading;

public class KitchenSimulation {
    public static void main(String[] args) {
        Thread sandwichThread = new Thread(new SandwichMaker());
        Thread coffeeThread = new Thread(new CoffeeBrewer());
        Thread dishThread = new Thread(new DishWasher());

        sandwichThread.start();
        coffeeThread.start();
        dishThread.start();

        try {
            sandwichThread.join();
            coffeeThread.join();
            dishThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All kitchen tasks are completed. Closing the kitchen.");
    }
}