package com.tutorialseu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tutorialseu.service")
public class AppConfig {
    // This configuration class will scan the service package for Spring components
}