package com.api.graphql.exceptions;

public class AccountAlreadyExistsException extends RuntimeException implements CustomException {
    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
