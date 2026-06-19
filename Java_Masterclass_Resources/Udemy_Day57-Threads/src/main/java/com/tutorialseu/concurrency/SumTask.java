// File: com/tutorialseu/concurrency/SumTask.java
package com.tutorialseu.concurrency;

import java.util.concurrent.Callable;

public class SumTask implements Callable<Integer> {
    private int[] numbers;

    public SumTask(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
            Thread.sleep(500); // Simulate work
        }
        System.out.println("Calculated sum: " + sum + " by " + Thread.currentThread().getName());
        return sum;
    }
}