// File: com/tutorialseu/concurrency/WithoutExecutorDemo.java
package com.tutorialseu.concurrency;

public class WithoutExecutorDemo {
    public static void main(String[] args) {
        String[] documents = {"Doc1.pdf", "Doc2.pdf", "Doc3.pdf", "Doc4.pdf", "Doc5.pdf"};

        for (String doc : documents) {
            Thread thread = new Thread(new PrintTask(doc));
            thread.start();
        }
    }
}
