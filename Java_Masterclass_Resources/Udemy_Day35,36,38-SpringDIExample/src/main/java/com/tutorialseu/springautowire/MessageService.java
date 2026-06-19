package com.tutorialseu.springautowire;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String getMessage() {
        return "Hello, Spring Autowiring!";
    }
}