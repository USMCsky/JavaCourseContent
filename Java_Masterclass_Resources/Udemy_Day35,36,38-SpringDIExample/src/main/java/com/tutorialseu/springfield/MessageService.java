package com.tutorialseu.springfield;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String getMessage() {
        return "Hello, Spring Field Injection!";
    }
}