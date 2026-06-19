// File: com/tutorialseu/threadmanagement/TaskControlDemo.java
package com.tutorialseu.threadmanagement;

public class TaskControlDemo {
    public static void main(String[] args) {
        TaskRunner taskRunner = new TaskRunner();
        Thread taskThread = new Thread(taskRunner);
        taskThread.start();

        try {
            Thread.sleep(5000); // Let the task run for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Requesting task to stop...");
        taskRunner.stop();
    }
}
