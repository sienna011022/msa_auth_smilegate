package com.auth.authserver;

import com.auth.authserver.domain.JwtTokenFactory;
import com.auth.authserver.web.dto.LoginRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class JwtTokenProviderTest {
    private final static int LENGTH_OF_TOKEN = 161;

    @Test
    void jwt_create() {
        LoginRequest request = new LoginRequest("sienna1022", "132234", Arrays.asList("ADMIN"));
        JwtTokenFactory factory = new JwtTokenFactory();
        Assertions.assertThat(factory.generateToken(request).get("member_id")).isEqualTo("sienna1022");
        Assertions.assertThat(factory.generateToken(request).get("access_token").length()).isEqualTo(LENGTH_OF_TOKEN);
        Assertions.assertThat(factory.generateToken(request).get("refresh_token").length()).isEqualTo(LENGTH_OF_TOKEN);
    }
}
