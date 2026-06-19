
package com.tutorialseu.threadcreation;

public class CountdownDemo {
    public static void main(String[] args) {
        CountdownThread countdown = new CountdownThread();
        countdown.start(); // Starts the thread and calls run()
    }
}
