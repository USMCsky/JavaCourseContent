package com.tutorialseu.springdi;

public class GreetingServiceImpl implements GreetingService {

    private final MessageService messageService;

    // Constructor Injection
    public GreetingServiceImpl(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void greet() {
        System.out.println("Constructor Injection: " + messageService.getMessage());
    }
}