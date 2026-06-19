package com.tutorialseu.peekingiterator;

import org.springframework.stereotype.Component;
import java.util.Iterator;

@Component
public class PeekingIterator<T> implements Iterator<T> {

    private Iterator<T> iterator;
    private T nextElement;

    // Setter method for injecting the Iterator after PeekingIterator is autowired
    public void setIterator(Iterator<T> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            nextElement = iterator.next();
        }
    }

    // Peek method to return the next element without advancing
    public T peek() {
        return nextElement;
    }

    // Override next method to advance the iterator
    @Override
    public T next() {
        T current = nextElement;
        nextElement = iterator.hasNext() ? iterator.next() : null;
        return current;
    }

    // Override hasNext method to check if there are more elements
    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}

