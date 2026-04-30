package com.example.demo.exception;

public class BusinessRuleViolationException extends RuntimeException {
    public BusinessRuleViolationException(String message) {
        super(message);
    }
}
