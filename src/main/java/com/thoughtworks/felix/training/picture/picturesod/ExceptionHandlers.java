package com.thoughtworks.felix.training.picture.picturesod;

import com.thoughtworks.felix.training.picture.picturesod.interfaces.rest.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity notFoundExceptionHandler(NotFoundException e) {
        return ResponseEntity.status(e.httpStatus()).build();
    }
}
