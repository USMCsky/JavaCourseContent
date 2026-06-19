// File: com/tutorialseu/concurrency/ExecutorServiceDemo.java
package com.tutorialseu.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        String[] documents = {"Doc1.pdf", "Doc2.pdf", "Doc3.pdf", "Doc4.pdf", "Doc5.pdf"};

        // Create a fixed thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (String doc : documents) {
            PrintTask task = new PrintTask(doc);
            executor.execute(task);
        }

        // Shutdown the executor
        executor.shutdown();
    }
}
