package com.auth.user.common.exception;

import lombok.Getter;

@Getter
public class IllegalPasswordException extends RuntimeException {
    private final ErrorType errorType;

    public IllegalPasswordException() {
        this.errorType = ErrorType.ILLEGAL_PASSWORD;
    }
}
