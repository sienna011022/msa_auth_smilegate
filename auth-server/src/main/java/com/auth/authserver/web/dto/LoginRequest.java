package com.auth.authserver.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class LoginRequest {

    private String memberId;
    private String password;
    private List<String> roles = new ArrayList<>();

    @Builder
    public LoginRequest(String memberId, String password, List<String> roles) {
        this.memberId = memberId;
        this.password = password;
        this.roles = roles;
    }
}
