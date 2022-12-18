package com.auth.user;

import com.auth.user.domain.Member;
import com.auth.user.domain.Role;
import com.auth.user.web.dto.LoginRequest;
import com.auth.user.web.dto.UserCreateRequest;

public class MemberFixture {

    public static UserCreateRequest memberCreateRequest() {
        UserCreateRequest request = UserCreateRequest.builder()
            .memberId("sienna1022")
            .name("kimSungYoon")
            .email("sienna011022@naver.com")
            .password("1234")
            .role(Role.GUEST)
            .build();

        return request;
    }

    public static Member memberCreateWithPassword(String password) {
        Member request = Member.builder()
            .memberId("sienna1022")
            .name("kimSungYoon")
            .email("sienna011022@naver.com")
            .password(password)
            .role(Role.GUEST)
            .build();

        return request;
    }

    public static Member createMemberByMemberId(String memberId) {
        Member request = Member.builder()
            .memberId(memberId)
            .name("kimSungYoon")
            .email("sienna011022@naver.com")
            .password("password")
            .role(Role.GUEST)
            .build();

        return request;
    }


    public static LoginRequest createLoginRequest() {
        LoginRequest request = LoginRequest.builder()
            .memberId("sienna1022")
            .password("abcd")
            .build();
        return request;
    }
}

