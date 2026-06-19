package com.tutorialseu.callcenter;

import java.util.PriorityQueue;

public class CallCenterSimulation {

    // PriorityQueue to hold and prioritize calls
    private PriorityQueue<Call> callQueue;

    public CallCenterSimulation() {
        // Initialize the queue with our custom comparator
        callQueue = new PriorityQueue<>(new CallPriorityComparator());
    }

    // Method to add a call to the queue
    public void addCall(String callID, int urgency, int waitingDuration) {
        Call call = new Call(callID, urgency, waitingDuration);
        callQueue.add(call);
        System.out.println("Added: " + call);
    }

    // Method to answer the next call in priority order
    public void answerCall() {
        if (!callQueue.isEmpty()) {
            Call nextCall = callQueue.poll();
            System.out.println("Answering: " + nextCall);
        } else {
            System.out.println("No calls in the queue.");
        }
    }

    public static void main(String[] args) {
        // Initialize the call center
        CallCenterSimulation callCenter = new CallCenterSimulation();

        // Add calls to the queue
        callCenter.addCall("C1", 5, 10);
        callCenter.addCall("C2", 3, 20);
        callCenter.addCall("C3", 5, 15);
        callCenter.addCall("C4", 2, 30);
        callCenter.addCall("C5", 4, 25);

        // Answer calls in prioritized order
        System.out.println("\\nProcessing Calls in Priority Order:");
        callCenter.answerCall(); // Expected: C3
        callCenter.answerCall(); // Expected: C1
        callCenter.answerCall(); // Expected: C5
        callCenter.answerCall(); // Expected: C2
        callCenter.answerCall(); // Expected: C4
    }
}