package com.auth.authserver.domain;

import com.auth.authserver.common.exception.IllegalTokenException;
import com.auth.authserver.common.exception.IllegalUserException;
import com.auth.authserver.web.dto.createJwtRequest;
import com.auth.authserver.web.dto.RefreshTokenRequest;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.*;

@Component
public class JwtTokenFactory {
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String MEMBER_ID = "member_id";
    private static final long ACCESS_TOKEN_VALID_TIME = 30 * 60 * 1000L;
    private static final long REFRESH_TOKEN_VALID_TIME = 30 * 60 * 1000L * 5;
    private String secretKey;

    public JwtTokenFactory(){
        secretKey = Base64.getEncoder().encodeToString("${jwt.secretKey}".getBytes());
    }

    public Map<String, String> generateTokens(createJwtRequest request) {
        Claims claims = makeClaims(request.getMemberId(), request.getRoles());
        Map<String, String> tokens = new HashMap();
        Date now = new Date();

        tokens.put(MEMBER_ID, request.getMemberId());
        tokens.put(ACCESS_TOKEN, makeAccessToken(claims, now));
        tokens.put(REFRESH_TOKEN, makeRefreshToken(claims, now));

        return tokens;
    }

    public String updateToken(RefreshTokenRequest request) {
        Claims claims = makeClaims(request.getMemberId(),request.getRoles());
        return makeAccessToken(claims, new Date());
    }

    public boolean isValidToken(String token, String memberId) {
        try {Jws<Claims> claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);
            isSameSubject(claims, memberId);
            return true;
        } catch (ExpiredJwtException exception) {
            throw new IllegalTokenException("토큰의 유효기간이 만료되었습니다");
        }
    }

    private Claims makeClaims(String memberId, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(memberId);
        claims.put("roles", roles);
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

    private void isSameSubject(Jws<Claims> claims, String memberId) {
        if (!claims.getBody().getSubject().equals(memberId)) {
            throw new IllegalUserException();
        }
    }

}
