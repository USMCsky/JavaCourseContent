package com.tutorialseu.springautowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    private final MessageService messageService;

    // Constructor Injection with Autowiring
    @Autowired
    public GreetingServiceImpl(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void greet() {
        System.out.println("Constructor Injection with Autowiring: " + messageService.getMessage());
    }
}

