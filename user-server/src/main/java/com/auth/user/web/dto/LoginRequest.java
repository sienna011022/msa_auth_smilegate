package com.auth.user.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LoginRequest {

    private String memberId;
    private String password;

   @Builder
    public LoginRequest(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }
}
