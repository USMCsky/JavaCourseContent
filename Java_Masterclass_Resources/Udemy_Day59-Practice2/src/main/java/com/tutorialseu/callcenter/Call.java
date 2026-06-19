package com.tutorialseu.callcenter;

// Define a class to represent a Call with urgency and waiting duration
class Call {
    int urgency;
    int waitingDuration;
    String callID;

    public Call(String callID, int urgency, int waitingDuration) {
        this.callID = callID;
        this.urgency = urgency;
        this.waitingDuration = waitingDuration;
    }

    @Override
    public String toString() {
        return "Call ID: " + callID + ", Urgency: " + urgency + ", Waiting Duration: " + waitingDuration;
    }
}