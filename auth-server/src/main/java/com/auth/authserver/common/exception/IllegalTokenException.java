package com.auth.authserver.common.exception;

import lombok.Getter;

@Getter
public class IllegalTokenException extends RuntimeException {
    private final ErrorType errorType;
    public IllegalTokenException(String message) {
        super(message);
        this.errorType = ErrorType.ILLEGAL_TOKEN;
    }
}
