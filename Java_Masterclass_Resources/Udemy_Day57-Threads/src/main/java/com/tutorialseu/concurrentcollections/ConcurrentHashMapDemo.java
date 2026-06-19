// File: com/tutorialseu/concurrentcollections/ConcurrentHashMapDemo.java
package com.tutorialseu.concurrentcollections;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        MapWorker worker = new MapWorker();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                worker.addToMap(i, "Value" + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                worker.addToMap(i, "Value" + i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final map size: " + worker.getMapSize());
    }
}
