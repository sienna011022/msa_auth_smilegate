package com.auth.authserver;

import com.auth.authserver.domain.JwtTokenFactory;
import com.auth.authserver.exception.NotSameMemberException;
import com.auth.authserver.web.dto.LoginRequest;
import com.auth.authserver.web.dto.ValidTokenRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JwtTokenFactoryTest {
    private final static int LENGTH_OF_TOKEN = 161;

    @Test
    @DisplayName("access token과 refresh token을 발급한다")
    void jwt_create() {
        LoginRequest request = new LoginRequest("sienna1022", "132234", Arrays.asList("ADMIN"));
        JwtTokenFactory factory = new JwtTokenFactory();

        Assertions.assertThat(factory.generateToken(request).get("member_id")).isEqualTo("sienna1022");
        Assertions.assertThat(factory.generateToken(request).get("access_token").length()).isEqualTo(LENGTH_OF_TOKEN);
        Assertions.assertThat(factory.generateToken(request).get("refresh_token").length()).isEqualTo(LENGTH_OF_TOKEN);
    }

    @Test
    @DisplayName("토큰안의 사용자와 요청하는 사용자가 일치하지 않으면 예외 발생")
    void jwt_valid_exception() {
        JwtTokenFactory factory = new JwtTokenFactory();
        LoginRequest loginRequest = new LoginRequest("sienna1022", "1022", Arrays.asList("ADMIN"));
        String accessToken = factory.generateToken(loginRequest).get("access_token");

        assertThatThrownBy(() -> factory.isValidToken(new ValidTokenRequest(accessToken, "sienna10223")))
            .isInstanceOf(NotSameMemberException.class);
    }
}
