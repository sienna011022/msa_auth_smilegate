package com.auth.authserver.common.exception;

import lombok.Getter;

@Getter
public class IllegalUserException extends RuntimeException {
    private final ErrorType errorType;
    public IllegalUserException() {
        this.errorType = ErrorType.ILLEGAL_USER;
    }
}
