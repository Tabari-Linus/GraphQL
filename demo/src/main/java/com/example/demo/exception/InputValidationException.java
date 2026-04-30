package com.example.demo.exception;

public class InputValidationException extends RuntimeException {
    public InputValidationException(String message) {
        super(message);
    }
}
