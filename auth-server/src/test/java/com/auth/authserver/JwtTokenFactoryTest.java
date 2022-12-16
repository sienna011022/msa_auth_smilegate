package com.auth.authserver;

import com.auth.authserver.domain.JwtTokenFactory;
import com.auth.authserver.exception.IllegalTokenException;
import com.auth.authserver.exception.NotSameMemberException;
import com.auth.authserver.web.dto.AccessTokenRequest;
import com.auth.authserver.web.dto.LoginRequest;
import com.auth.authserver.web.dto.RefreshTokenRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JwtTokenFactoryTest {
    private final static int LENGTH_OF_TOKEN = 161;

    @Test
    @DisplayName("access token과 refresh token을 발급한다")
    void jwt_create() {
        LoginRequest request = new LoginRequest("sienna1022", "132234", Arrays.asList("ADMIN"));
        JwtTokenFactory factory = new JwtTokenFactory();

        Assertions.assertThat(factory.generateTokens(request).get("member_id")).isEqualTo("sienna1022");
        Assertions.assertThat(factory.generateTokens(request).get("access_token").length()).isEqualTo(LENGTH_OF_TOKEN);
        Assertions.assertThat(factory.generateTokens(request).get("refresh_token").length()).isEqualTo(LENGTH_OF_TOKEN);
    }

    @Test
    @DisplayName("토큰안의 사용자와 요청하는 사용자가 일치하지 않으면 예외 발생")
    void jwt_valid_exception1() {
        JwtTokenFactory factory = new JwtTokenFactory();
        LoginRequest loginRequest = new LoginRequest("sienna1022", "1022", Arrays.asList("ADMIN"));
        String accessToken = factory.generateTokens(loginRequest).get("access_token");

        assertThatThrownBy(() -> factory.isValidToken(accessToken, "sienna1022"))
            .isInstanceOf(NotSameMemberException.class);
    }

    @Test
    @DisplayName("토큰의 유효기간이 만료 되었을 경우 예외 발생")
    void jwt_valid_exception2() {
        JwtTokenFactory factory = new JwtTokenFactory();
        LoginRequest loginRequest = new LoginRequest("sienna1022", "1022", Arrays.asList("ADMIN"));
        assertThatThrownBy(() -> factory.isValidToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzaWVubmExMDIyIiwicm9sZXMiOltdLCJpYXQiOjE2NzExOTMyNzYsImV4cCI6MTY3MTE5NTA3Nn0.xVPicO-yTpH6TcpY5KlnXmYTC5u8IU75CGi5WUVJ3gI", loginRequest.getMemberId()))
            .isInstanceOf(IllegalTokenException.class);
    }

}
