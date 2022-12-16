package com.auth.authserver.web.dto;

import lombok.Getter;

@Getter
public class AccessTokenRequest {
    private String accessToken;
    private String memberId;

    public AccessTokenRequest(String accessToken, String memberId) {
        this.accessToken = accessToken;
        this.memberId = memberId;
    }
}
