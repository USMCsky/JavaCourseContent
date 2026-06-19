package com.tutorialseu.pitfalls;

import org.springframework.stereotype.Service;

@Service
public class CasualGreetingService implements GreetingService {

    @Override
    public String greet() {
        return "Hey, what's up?";
    }
}