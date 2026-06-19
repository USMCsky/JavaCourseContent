package com.tutorialseu.todoapp.exceptions;

public class EmptyTaskTitleException extends Exception {
    public EmptyTaskTitleException(String message) {
        super(message);
    }
}
