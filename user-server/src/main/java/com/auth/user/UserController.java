package com.auth.user;

import com.auth.user.web.dto.LoginRequest;
import com.auth.user.web.dto.UserCreateRequest;
import com.auth.user.web.service.LoginService;
import com.auth.user.web.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final SignUpService signUpService;
    private final LoginService loginService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserCreateRequest request) {
        signUpService.createUser(request);
        return status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest request) {
        loginService.login(request);
        return ok().build();
    }

}
