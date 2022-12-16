package com.auth.authserver.web;

import com.auth.authserver.domain.JwtTokenFactory;
import com.auth.authserver.domain.Token;
import com.auth.authserver.domain.TokenRepository;
import com.auth.authserver.web.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class TokenService {

    private static final String REFRESH_TOKEN = "refresh_token";

    private final JwtTokenFactory jwtTokenFactory;
    private final TokenRepository tokenRepository;

    public Map<String,String> createJWT(LoginRequest loginRequest) {
        Map<String, String> tokens = jwtTokenFactory.generateToken(loginRequest);
        Token refreshToken = Token.of(tokens.get(REFRESH_TOKEN));
        tokenRepository.save(refreshToken);
        tokens.put(REFRESH_TOKEN,refreshToken.uuid().toString());
        return tokens;
    }
}
