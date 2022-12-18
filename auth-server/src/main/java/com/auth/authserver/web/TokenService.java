package com.auth.authserver.web;

import com.auth.authserver.common.exception.IllegalTokenException;
import com.auth.authserver.domain.JwtTokenFactory;
import com.auth.authserver.domain.Token;
import com.auth.authserver.domain.TokenRepository;
import com.auth.authserver.web.dto.RefreshTokenRequest;
import com.auth.authserver.web.dto.createJwtRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TokenService {

    private static final String REFRESH_TOKEN = "refresh_token";
    private final JwtTokenFactory jwtTokenFactory;
    private final TokenRepository tokenRepository;

    public Map<String, String> createJWT(createJwtRequest loginRequest) {
        Map<String, String> tokens = jwtTokenFactory.generateTokens(loginRequest);
        Token refreshToken = Token.of(tokens.get(REFRESH_TOKEN));
        tokenRepository.save(refreshToken);
        tokens.put(REFRESH_TOKEN, refreshToken.uuid().toString());
        return tokens;
    }

    public void validAccessToken(String accessToken, String userId) {
        jwtTokenFactory.isValidToken(accessToken,userId);
    }

    public String validRefreshToken(UUID refreshToken, RefreshTokenRequest request) {
        Token token = tokenRepository.findById(refreshToken)
            .orElseThrow(() -> new IllegalTokenException("서버에 저장된 토큰의 정보를 확인할 수 없습니다"));

        if (!jwtTokenFactory.isValidToken(token.token(),request.getMemberId())) {
            tokenRepository.delete(token);
        }

        return jwtTokenFactory.updateToken(request);
    }

}
