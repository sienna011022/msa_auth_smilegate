package com.auth.authserver.domain;

import com.auth.authserver.web.dto.LoginRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.*;

@RequiredArgsConstructor
@Component
public class JwtTokenFactory {
    private static final long ACCESS_TOKEN_VALID_TIME = 30 * 60 * 1000L;
    private static final long REFRESH_TOKEN_VALID_TIME = 30 * 60 * 1000L * 5;
    private String secretKey = "thisIsSecretKey";

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public Map<String, String> generateToken(LoginRequest loginRequest) {

        Claims claims = makeClaims(loginRequest);
        Map<String, String> tokens = new HashMap();
        Date now = new Date();

        tokens.put("member_id", loginRequest.getMemberId());
        tokens.put("access_token", makeAccessToken(claims, now));
        tokens.put("refresh_token", makeRefreshToken(claims, now));

        return tokens;
    }

    private Claims makeClaims(LoginRequest loginRequest) {
        Claims claims = Jwts.claims().setSubject(loginRequest.getMemberId());
        claims.put("roles", loginRequest.getRoles());
        return claims;
    }

    private String makeRefreshToken(Claims claims, Date now) {
        return Jwts.builder()
            .setHeaderParams(Jwts.header())
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(new Date(now.getTime() + REFRESH_TOKEN_VALID_TIME))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }

    private String makeAccessToken(Claims claims, Date now) {
        return Jwts.builder()
            .setHeaderParams(Jwts.header())
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(new Date(now.getTime() + ACCESS_TOKEN_VALID_TIME))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }

}
