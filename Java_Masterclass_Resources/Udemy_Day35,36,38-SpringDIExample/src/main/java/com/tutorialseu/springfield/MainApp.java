package com.tutorialseu.springfield;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Using Field Injection
        GreetingService greetingService = context.getBean(GreetingService.class);
        greetingService.greet();
    }
}