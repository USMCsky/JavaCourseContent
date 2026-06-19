package com.tutorialseu.peekingiterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Iterator;
import java.util.List;

@Component
public class Handler {

    @Autowired
    private PeekingIterator<Integer> peekingIterator;

    @Autowired
    private InputService inputService;

    // Method to handle the main logic
    public void handleInputAndOutput() {
        // Step 1: Collect input from the user
        List<Integer> userList = inputService.collectInput();
        Iterator<Integer> iterator = userList.iterator();

        // Step 2: Set the iterator in the PeekingIterator
        peekingIterator.setIterator(iterator);

        // Step 3: Display elements using PeekingIterator
        System.out.println("PeekingIterator functionality:");
        while (peekingIterator.hasNext()) {
            System.out.println("Peek: " + peekingIterator.peek());
            System.out.println("Next: " + peekingIterator.next());
        }
    }
}