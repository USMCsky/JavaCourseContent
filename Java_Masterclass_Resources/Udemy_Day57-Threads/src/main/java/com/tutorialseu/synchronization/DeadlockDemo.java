package com.tutorialseu.synchronization;

public class DeadlockDemo {

    private final Object ResourceA = new Object();
    private final Object ResourceB = new Object();

    public void methodOne() {
        synchronized (ResourceA) {
            System.out.println("Thread 1: Locked ResourceA");

            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (ResourceB) {
                System.out.println("Thread 1: Locked ResourceB");
            }
        }
    }

    public void methodTwo() {
        synchronized (ResourceB) {
            System.out.println("Thread 2: Locked ResourceB");

            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (ResourceA) {
                System.out.println("Thread 2: Locked ResourceA");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockDemo demo = new DeadlockDemo();

        Thread t1 = new Thread(() -> demo.methodOne());
        Thread t2 = new Thread(() -> demo.methodTwo());

        t1.start();
        t2.start();
    }
}
