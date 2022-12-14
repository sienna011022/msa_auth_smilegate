package com.auth.authserver;

import com.auth.authserver.domain.JwtTokenFactory;
import com.auth.authserver.web.dto.LoginRequest;
import com.auth.authserver.web.dto.ValidTokenRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenFactory jwtTokenFactory;

    @PostMapping("/newJwt")
    public Map<String, String> createJwt(@RequestBody LoginRequest loginRequest) {
        Map<String, String> tokens = jwtTokenFactory.generateToken(loginRequest);
        return tokens;
    }
    @PostMapping("/validJwt")
    public void validJwt(@RequestBody ValidTokenRequest tokenRequest){
        jwtTokenFactory.isValidToken(tokenRequest);
    }

}
