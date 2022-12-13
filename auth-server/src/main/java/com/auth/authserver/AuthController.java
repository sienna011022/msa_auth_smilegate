package com.auth.authserver;

import com.auth.authserver.domain.JwtTokenFactory;
import com.auth.authserver.web.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController()
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenFactory jwtTokenFactory;

    @PostMapping("/jwt")
    public Map<String, String> createJwt(@RequestBody LoginRequest loginRequest) {
        Map<String, String> tokens = jwtTokenFactory.generateToken(loginRequest);
        return tokens;
    }
}
