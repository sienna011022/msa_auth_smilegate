package com.auth.authserver.web;

import com.auth.authserver.domain.JwtTokenFactory;
import com.auth.authserver.domain.Token;
import com.auth.authserver.domain.TokenRepository;
import com.auth.authserver.web.dto.RefreshTokenRequest;
import com.auth.authserver.web.dto.createJwtRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Token token = tokenRepository.findById(refreshToken).orElseThrow(() -> new RuntimeException());
        if (!jwtTokenFactory.isValidToken(token.token(),request.getMemberId())) {
            tokenRepository.delete(token);
        }

        return jwtTokenFactory.updateToken(request);
    }

}
