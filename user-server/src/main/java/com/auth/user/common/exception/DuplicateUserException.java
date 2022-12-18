package com.auth.user.common.exception;

import lombok.Getter;

@Getter
public class DuplicateUserException extends RuntimeException{

    private final ErrorType errorType;

    public DuplicateUserException() {
        this.errorType = ErrorType.DUPLICATE_USER;
    }
}
