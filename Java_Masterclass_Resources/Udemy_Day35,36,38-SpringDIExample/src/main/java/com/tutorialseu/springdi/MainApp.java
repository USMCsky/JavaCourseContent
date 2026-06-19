package com.tutorialseu.springdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Using Constructor Injection
        GreetingService greetingService = context.getBean("greetingService" ,GreetingService.class);
        greetingService.greet();

        // Using Setter Injection
        GreetingService greetingServiceSetter = context.getBean("greetingServiceSetter", GreetingService.class);
        greetingServiceSetter.greet();
    }
}