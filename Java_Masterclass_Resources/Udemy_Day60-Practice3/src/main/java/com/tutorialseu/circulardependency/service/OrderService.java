package com.tutorialseu.circulardependency.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private UserService userService;

    // Constructor injection with @Lazy
    public OrderService(@Lazy UserService userService) {
        this.userService = userService;
    }

    public void createOrder() {
        System.out.println("Order created.");
    }
}
