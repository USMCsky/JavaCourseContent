package com.tutorialseu.callcenter;

import java.util.Comparator;

// Comparator for PriorityQueue to sort calls based on urgency and waiting duration
class CallPriorityComparator implements Comparator<Call> {
    @Override
    public int compare(Call c1, Call c2) {
        if (c1.urgency != c2.urgency) {
            return Integer.compare(c2.urgency, c1.urgency); // Higher urgency first
        } else {
            return Integer.compare(c2.waitingDuration, c1.waitingDuration); // Longer waiting duration first
        }
    }
}