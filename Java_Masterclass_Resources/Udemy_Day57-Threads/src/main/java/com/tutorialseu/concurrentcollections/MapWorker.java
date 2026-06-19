// File: com/tutorialseu/concurrentcollections/MapWorker.java
package com.tutorialseu.concurrentcollections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapWorker {
    private Map<Integer, String> map = new ConcurrentHashMap<>();

    public void addToMap(int key, String value) {
        map.put(key, value);
    }

    public int getMapSize() {
        return map.size();
    }
}
