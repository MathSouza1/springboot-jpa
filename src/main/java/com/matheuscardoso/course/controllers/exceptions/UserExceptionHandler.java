package com.matheuscardoso.course.controllers.exceptions;

import com.matheuscardoso.course.services.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardException> resourceNotFound(UserNotFoundException exception) {
        StandardException standardException = new StandardException(Instant.now(), HttpStatus.NOT_FOUND.value(), "User not found", exception.getMessage());
        return new ResponseEntity<>(standardException, HttpStatus.NOT_FOUND);
    }
}
