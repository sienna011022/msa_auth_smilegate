package com.auth.user.common.exception;

import lombok.Getter;

@Getter
public class ExistsUserException extends RuntimeException{

    private final ErrorType errorType;

    public ExistsUserException() {
        this.errorType = ErrorType.DUPLICATE_USER;
    }
}
