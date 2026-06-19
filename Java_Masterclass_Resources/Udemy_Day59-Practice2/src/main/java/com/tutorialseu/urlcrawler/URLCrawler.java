package com.tutorialseu.urlcrawler;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class URLCrawler {
    public static void main(String[] args) {
        String startUrl = "https://google.com";
        Set<String> visitedUrls = ConcurrentHashMap.newKeySet(); // Thread-safe set for visited URLs

        ExecutorService executor = Executors.newFixedThreadPool(10); // Pool with 10 threads

        try {
            executor.submit(new URLCrawlerTask(startUrl, 1, visitedUrls, executor)).get(); // Start crawling
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}