package com.tutorialseu.peekingiterator;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.tutorialseu.peekingiterator")  // Adjust to your project structure
public class ConfigClass {
    // No need to manually define beans; ComponentScan will auto-detect them
}
