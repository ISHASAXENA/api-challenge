package com.api.graphql.exceptions;

public class UserNotFoundException extends RuntimeException implements CustomException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
