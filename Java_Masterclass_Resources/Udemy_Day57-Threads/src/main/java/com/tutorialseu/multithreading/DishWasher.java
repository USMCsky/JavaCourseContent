// File: com/tutorialseu/multithreading/DishWasher.java
package com.tutorialseu.multithreading;

public class DishWasher implements Runnable {
    @Override
    public void run() {
        String[] dishes = {"Plates", "Cups", "Cutlery"};
        for (String dish : dishes) {
            System.out.println("Washing " + dish);
            try {
                Thread.sleep(1200); // Simulate time to wash dishes
            } catch (InterruptedException e) {
                System.out.println("Dish washing interrupted");
            }
        }
        System.out.println("All dishes are clean!");
    }
}
