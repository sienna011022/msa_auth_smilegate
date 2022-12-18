package com.auth.authserver.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(IllegalTokenException.class)
    protected ResponseEntity<ErrorResponse> tokenException(IllegalTokenException exception){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(ErrorResponse.of(exception.getErrorType(),exception.getMessage()));
    }

    @ExceptionHandler(IllegalUserException.class)
    protected ResponseEntity<ErrorResponse> userException(IllegalUserException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse.of(exception.getErrorType()));
    }
}
