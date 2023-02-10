package com.api.graphql.exceptions;

public class AccountNotFoundException extends RuntimeException implements CustomException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
