// File: com/tutorialseu/concurrency/CallableDemo.java
package com.tutorialseu.concurrency;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        int[][] dataSets = {
                {1, 2, 3, 4, 5},
                {10, 20, 30},
                {100, 200},
                {1000}
        };

        Future<Integer>[] results = new Future[dataSets.length];

        for (int i = 0; i < dataSets.length; i++) {
            SumTask task = new SumTask(dataSets[i]);
            results[i] = executor.submit(task);
        }

        executor.shutdown();

        // Retrieve results
        for (int i = 0; i < results.length; i++) {
            try {
                int sum = results[i].get();
                System.out.println("Result of data set " + (i + 1) + ": " + sum);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
