package com.matheuscardoso.course.controllers.exceptions;

import com.matheuscardoso.course.services.exceptions.DatabaseException;
import com.matheuscardoso.course.services.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardException> userNotFound(UserNotFoundException exception) {
        StandardException standardException = new StandardException(Instant.now(), HttpStatus.NOT_FOUND.value(), "User not found", exception.getMessage());
        return new ResponseEntity<>(standardException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardException> dataBaseException(DatabaseException exception) {
        StandardException standardException = new StandardException(Instant.now(), HttpStatus.BAD_REQUEST.value(), "Database error", exception.getMessage());
        return new ResponseEntity<>(standardException, HttpStatus.BAD_REQUEST);
    }
}
