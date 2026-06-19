package com.tutorialseu.peekingiterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);

        // Retrieve the Handler bean from the context
        Handler handler = context.getBean(Handler.class);

        // Execute the input/output logic
        handler.handleInputAndOutput();
    }
}