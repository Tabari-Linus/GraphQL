package com.mrlii.graphqldemo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(PlayerNotFoundException.class)
    public String handlePlayerNotFoundException(PlayerNotFoundException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(InvalidPlayerIdException.class)
    public String handleInvalidPlayerIdException(InvalidPlayerIdException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex){
        return ex.getMessage();
    }
}
