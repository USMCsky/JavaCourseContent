package com.tutorialseu.springdi;

public class GreetingServiceSetterImpl implements GreetingService {

    private MessageService messageService;

    // Setter Injection
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void greet() {
        System.out.println("Setter Injection: " + messageService.getMessage());
    }
}