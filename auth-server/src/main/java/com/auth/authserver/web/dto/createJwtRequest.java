package com.auth.authserver.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class createJwtRequest {

    private String memberId;
    private List<String> roles;

    @Builder
    public createJwtRequest(String memberId, List<String> roles) {
        this.memberId = memberId;
        this.roles = roles;
    }
}
