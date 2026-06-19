package com.tutorialseu.springdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GreetingService greetingService() {
        return new GreetingServiceImpl(messageService());
    }

    @Bean
    public GreetingService greetingServiceSetter() {
        GreetingServiceSetterImpl service = new GreetingServiceSetterImpl();
        service.setMessageService(messageService());
        return service;
    }

    @Bean
    public MessageService messageService() {
        return new MessageService();
    }
}

