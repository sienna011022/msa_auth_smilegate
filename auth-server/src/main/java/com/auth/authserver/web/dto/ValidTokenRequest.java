package com.auth.authserver.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ValidTokenRequest {

    private String token;
    private String memberId;

    public ValidTokenRequest(String token, String memberId) {
        this.token = token;
        this.memberId = memberId;
    }
}
