package com.auth.authserver.exception;

public class NotSameMemberException extends RuntimeException {
    public NotSameMemberException(String message) {
        super(message);
    }
}
