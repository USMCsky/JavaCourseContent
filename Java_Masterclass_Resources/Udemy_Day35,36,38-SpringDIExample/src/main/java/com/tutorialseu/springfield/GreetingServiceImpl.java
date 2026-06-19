package com.tutorialseu.springfield;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Autowired
    private MessageService messageService;

    @Override
    public void greet() {
        System.out.println("Field Injection: " + messageService.getMessage());
    }
}