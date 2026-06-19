package com.tutorialseu.urlcrawler;

import com.tutorialseu.urlcrawler.exception.InvalidURLException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class URLCrawlerTask implements Callable<Void> {
    private final String url;
    private final int depth;
    private final Set<String> visitedUrls;
    private final ExecutorService executor;
    private static final int MAX_DEPTH = 3;

    // Pattern to match URLs within HTML content
    private static final Pattern URL_PATTERN = Pattern.compile("href\\s*=\\s*\"(http[s]?://[^\\s\"<>]+)\"");

    public URLCrawlerTask(String url, int depth, Set<String> visitedUrls, ExecutorService executor) {
        this.url = url;
        this.depth = depth;
        this.visitedUrls = visitedUrls;
        this.executor = executor;
    }

    @Override
    public Void call() throws Exception {
        // If maximum depth is reached, stop further crawling
        if (depth > MAX_DEPTH) return null;

        // Crawl the URL only if it hasn't been visited
        synchronized (visitedUrls) {
            if (visitedUrls.contains(url)) {
                return null;
            }
            visitedUrls.add(url);
        }

        System.out.println("Crawling URL: " + url + " at depth: " + depth);

        try {
            // Fetch and parse links from the current URL
            Set<String> links = fetchLinks(url);
            for (String link : links) {
                executor.submit(new URLCrawlerTask(link, depth + 1, visitedUrls, executor));
            }
        } catch (InvalidURLException | IOException e) {
            System.err.println("Error crawling URL: " + url + " - " + e.getMessage());
        }

        return null;
    }

    // Fetch links from the given URL
    private Set<String> fetchLinks(String url) throws InvalidURLException, IOException {
        Set<String> links = new HashSet<>();
        HttpURLConnection connection = null;

        try {
            URL urlObj = new URL(url);
            connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Check for a successful response code
            if (connection.getResponseCode() != 200) {
                throw new IOException("Failed to fetch page");
            }

            // Simulate retrieving links with a simple regex (in practice, use a parser like Jsoup)
            String pageContent = new String(connection.getInputStream().readAllBytes());
            Matcher matcher = URL_PATTERN.matcher(pageContent);
            while (matcher.find()) {
                String foundUrl = matcher.group(1);
                links.add(foundUrl);
            }
        } catch (MalformedURLException e) {
            throw new InvalidURLException("Invalid URL: " + url);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return links;
    }
}