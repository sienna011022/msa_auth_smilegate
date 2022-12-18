package com.auth.authserver.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorType {

    ILLEGAL_TOKEN("A001", "유효하지 않는 토큰입니다"),
    ILLEGAL_USER("A002", "토큰과 일치하지 않는 사용자입니다");

    private final String code;
    private final String message;



}
