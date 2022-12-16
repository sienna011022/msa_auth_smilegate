package com.auth.authserver.domain;

import com.auth.authserver.exception.IllegalTokenException;
import com.auth.authserver.exception.NotSameMemberException;
import com.auth.authserver.web.dto.LoginRequest;
import com.auth.authserver.web.dto.ValidTokenRequest;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.*;

@RequiredArgsConstructor
@Component
public class JwtTokenFactory {
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String MEMBER_ID = "memberId";
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

        tokens.put(MEMBER_ID, loginRequest.getMemberId());
        tokens.put(ACCESS_TOKEN, makeAccessToken(claims, now));
        tokens.put(REFRESH_TOKEN, makeRefreshToken(claims, now));

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

    public void isValidToken(ValidTokenRequest request) {
        try {
            Jws<Claims> claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(request.getToken());
            isSameSubject(claims, request.getMemberId());
        } catch (JwtException exception) {
            throw new IllegalTokenException(exception.getMessage());
        }
    }


    private void isSameSubject(Jws<Claims> claims, String memberId) {
        if (claims.getBody().getSubject() != memberId) {
            throw new NotSameMemberException("요청하신 토큰과 다른 사용자입니다");
        }
    }

}
