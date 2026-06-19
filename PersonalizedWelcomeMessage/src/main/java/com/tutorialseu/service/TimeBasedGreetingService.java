package com.tutorialseu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;

@Service
public class TimeBasedGreetingService implements GreetingService {

    @Autowired
    private MessageService messageService;

    @Override
    public String getGreeting() {
        String userName = messageService.getUserName();
        LocalTime currentTime = LocalTime.now();
        String greeting;

        if (currentTime.isBefore(LocalTime.NOON)) {
            greeting = "Good morning";
        } else if (currentTime.isBefore(LocalTime.of(18, 0))) {
            greeting = "Good afternoon";
        } else {
            greeting = "Good evening";
        }

        return greeting + ", " + userName + "!";
    }
}