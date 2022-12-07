package com.auth.user;

import com.auth.user.domain.Role;
import com.auth.user.web.dto.MemberCreateRequest;

public class MemberFixture {

    public static MemberCreateRequest createMemberCreateRequest() {
        MemberCreateRequest request = MemberCreateRequest.builder()
            .memberId("sienna1022")
            .name("kimSungYoon")
            .email("sienna011022@naver.com")
            .password("abcd")
            .role(Role.GUEST)
            .build();

        return request;
    }
}

