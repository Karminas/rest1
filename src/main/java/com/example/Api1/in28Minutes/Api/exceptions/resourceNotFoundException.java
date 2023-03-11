package com.example.Api1.in28Minutes.Api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class resourceNotFoundException extends RuntimeException{

    public resourceNotFoundException(String message) {
        super(message);
    }
}
