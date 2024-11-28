package com.springboot.focusphysique.backend.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptio extends RuntimeException{
    public ResourceNotFoundExceptio (String message){
        super(message);
    }
}
