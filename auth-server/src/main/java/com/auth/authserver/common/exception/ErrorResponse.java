package com.auth.authserver.common.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private String message;
    private String code;

    private String details ;

    private ErrorResponse(ErrorType errorType,String details) {
       this(errorType);
       this.details = details;
    }

    private ErrorResponse(ErrorType errorType) {
        this.message = errorType.getMessage();
        this.code = errorType.getCode();
    }

    public static ErrorResponse of(ErrorType errorType,String details) {
        return new ErrorResponse(errorType,details);
    }

    public static ErrorResponse of(ErrorType errorType) {
        return new ErrorResponse(errorType);
    }
}
