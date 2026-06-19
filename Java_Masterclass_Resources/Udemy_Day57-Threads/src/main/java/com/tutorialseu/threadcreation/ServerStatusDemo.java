package com.tutorialseu.threadcreation;

public class ServerStatusDemo {
    public static void main(String[] args) {
        Thread statusThread = new Thread(new ServerStatusChecker());
        statusThread.start(); // Starts the thread and calls run()
    }
}