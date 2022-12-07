package com.auth.user.web.dto;

import com.auth.user.domain.Member;
import com.auth.user.domain.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberCreateRequest {

    private String memberId;

    private String password;

    private String name;

    private String email;

    private Role role;

    @Builder
    public MemberCreateRequest(String memberId, String password, String name, String email, Role role) {
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public Member toMember() {
        return Member.builder()
            .memberId(memberId)
            .password(password)
            .name(name)
            .email(email)
            .role(role)
            .build();
    }
}
