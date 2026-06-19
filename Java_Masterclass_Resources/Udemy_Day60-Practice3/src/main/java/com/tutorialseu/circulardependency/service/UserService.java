package com.tutorialseu.circulardependency.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final OrderService orderService;

    // Constructor injection with @Lazy
    public UserService(@Lazy OrderService orderService) {
        this.orderService = orderService;
    }

    public void createUser() {
        System.out.println("User created.");
        orderService.createOrder();
    }
}
