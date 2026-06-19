// File: com/tutorialseu/concurrentcollections/ListWorker.java
package com.tutorialseu.concurrentcollections;

import java.util.ArrayList;
import java.util.List;

public class ListWorker {
    private List<Integer> list = new ArrayList<>();

    public void addToList(int value) {
        list.add(value);
    }

    public int getListSize() {
        return list.size();
    }
}
