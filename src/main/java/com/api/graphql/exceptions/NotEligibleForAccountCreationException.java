package com.api.graphql.exceptions;

public class NotEligibleForAccountCreationException extends RuntimeException implements CustomException{
    public NotEligibleForAccountCreationException(String message) {
        super(message);
    }
}
