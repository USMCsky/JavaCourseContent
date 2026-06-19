// File: com/tutorialseu/concurrentcollections/ArrayListDemo.java
package com.tutorialseu.concurrentcollections;

public class ArrayListDemo {
    public static void main(String[] args) {
        ListWorker worker = new ListWorker();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                worker.addToList(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                worker.addToList(i);
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

        System.out.println("Final list size: " + worker.getListSize());
    }
}
