package com.example.inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserFoundException extends RuntimeException {
    public UserFoundException(String message) {
        super(message);
    }
}

