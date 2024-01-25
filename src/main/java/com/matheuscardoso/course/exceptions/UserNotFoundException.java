package com.matheuscardoso.course.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Object object) {
        super("Unable to find the User with id: " + object);
    }
}
