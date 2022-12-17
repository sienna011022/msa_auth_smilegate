package com.auth.authserver.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class RefreshTokenRequest {
    private UUID refreshToken;
    private String memberId;
    private List<String> roles;

    public RefreshTokenRequest(UUID refreshToken, String memberId, List<String> roles) {
        this.refreshToken = refreshToken;
        this.memberId = memberId;
        this.roles = roles;
    }

    public UUID refreshToken() {
        return refreshToken;
    }
}
