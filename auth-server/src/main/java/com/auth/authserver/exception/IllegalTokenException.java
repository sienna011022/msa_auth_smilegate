package com.auth.authserver.exception;

public class IllegalTokenException extends RuntimeException {
    public IllegalTokenException(String message) {
        super(message);
    }
}
