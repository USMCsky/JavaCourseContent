package com.tutorialseu.main;

import com.tutorialseu.config.AppConfig;
import com.tutorialseu.service.GreetingService;
import com.tutorialseu.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        // Initialize Spring application context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the MessageService bean and set the user's name
        MessageService messageService = context.getBean(MessageService.class);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        messageService.setUserName(userName);

        // Get the GreetingService bean and display personalized greeting
        GreetingService greetingService = context.getBean(GreetingService.class);
        String personalizedGreeting = greetingService.getGreeting();
        System.out.println(personalizedGreeting);
    }
}