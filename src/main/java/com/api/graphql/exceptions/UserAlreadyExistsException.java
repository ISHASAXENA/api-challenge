package com.api.graphql.exceptions;

public class UserAlreadyExistsException extends RuntimeException implements CustomException{
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
