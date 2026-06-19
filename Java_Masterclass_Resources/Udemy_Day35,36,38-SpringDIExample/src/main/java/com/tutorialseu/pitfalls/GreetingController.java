package com.tutorialseu.pitfalls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    public void deliverGreeting() {
        System.out.println(greetingService.greet());
    }
}