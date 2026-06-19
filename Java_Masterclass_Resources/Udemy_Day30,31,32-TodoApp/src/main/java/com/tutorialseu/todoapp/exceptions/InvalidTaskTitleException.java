package com.tutorialseu.todoapp.exceptions;

public class InvalidTaskTitleException extends Exception {
    public InvalidTaskTitleException(String message) {
        super(message);
    }
}
