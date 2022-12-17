package com.auth.authserver;

import com.auth.authserver.web.TokenService;
import com.auth.authserver.web.dto.createJwtRequest;
import com.auth.authserver.web.dto.RefreshTokenRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController()
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;

    @PostMapping("/token")
    public Map<String, String> createJwt(@RequestBody createJwtRequest request) {
        Map<String, String> tokens = tokenService.createJWT(request);
        return tokens;
    }

    @PostMapping("/access")
    public ResponseEntity validJwt(@RequestHeader(value = "Authorization") String accessToken, @RequestHeader(value = "UserId") String userId) {
        tokenService.validAccessToken(accessToken, userId);
        return ResponseEntity.ok("userId");
    }

    @PostMapping("/refresh")
    public void validRefreshToken(@RequestHeader(value = "Authorization") UUID refreshToken,@RequestBody RefreshTokenRequest request) {
        tokenService.validRefreshToken(refreshToken,request);
    }

}
