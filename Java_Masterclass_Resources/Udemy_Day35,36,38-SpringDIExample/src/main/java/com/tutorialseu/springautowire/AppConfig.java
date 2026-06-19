package com.tutorialseu.springautowire;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tutorialseu.springautowire")
public class AppConfig {
    // No explicit bean definitions needed for autowired components
}