package com.auth.authserver.web;

public class LoginRequest {
    private final String userId;
    private final String password;

    public LoginRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
