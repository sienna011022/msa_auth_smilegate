package com.auth.authserver;

import com.auth.authserver.web.LoginRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberTest {

    @Test
    void 로그인_요청_생성(){
        assertThat(new LoginRequest("sienna1022","password")).isInstanceOf(LoginRequest.class);
    }

}
