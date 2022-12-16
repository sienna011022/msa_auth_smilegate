package com.auth.authserver;

import com.auth.authserver.domain.JwtTokenFactory;
import com.auth.authserver.web.TokenService;
import com.auth.authserver.web.dto.AccessTokenRequest;
import com.auth.authserver.web.dto.LoginRequest;
import com.auth.authserver.web.dto.RefreshTokenRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;

    @PostMapping("/token")
    public Map<String, String> createJwt(@RequestBody LoginRequest loginRequest) {
        Map<String, String> tokens = tokenService.createJWT(loginRequest);
        return tokens;
    }
    @PostMapping("/access")
    public void validJwt(@RequestBody AccessTokenRequest tokenRequest){
        tokenService.validAccessToken(tokenRequest);
    }

    @PostMapping("/refresh")
    public void validRefreshToken(@RequestBody RefreshTokenRequest tokenRequest){
        tokenService.validRefreshToken(tokenRequest);
    }

}
