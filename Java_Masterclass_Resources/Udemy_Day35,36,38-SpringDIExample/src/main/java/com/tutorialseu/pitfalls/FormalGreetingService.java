package com.tutorialseu.pitfalls;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class FormalGreetingService implements GreetingService {

    @Override
    public String greet() {
        return "Good afternoon, sir.";
    }
}
