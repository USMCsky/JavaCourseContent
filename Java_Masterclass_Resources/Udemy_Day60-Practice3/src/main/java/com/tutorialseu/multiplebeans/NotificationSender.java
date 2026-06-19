package com.tutorialseu.multiplebeans;

import com.tutorialseu.multiplebeans.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationSender {

    private final List<NotificationService> notificationServices;

    @Autowired
    public NotificationSender(List<NotificationService> notificationServices) {
        this.notificationServices = notificationServices;
    }

    public void send(String message) {
        for (NotificationService service : notificationServices) {
            service.sendNotification(message);
        }
    }
}
