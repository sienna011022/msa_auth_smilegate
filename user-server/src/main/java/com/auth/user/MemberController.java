package com.auth.user;

import com.auth.user.web.dto.LoginRequest;
import com.auth.user.web.dto.MemberCreateRequest;
import com.auth.user.web.service.LoginService;
import com.auth.user.web.service.SignUpService;
import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/members")
public class MemberController {

    private final SignUpService signUpService;
    private final LoginService loginService;


    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody MemberCreateRequest request) {
        signUpService.createMember(request);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(loginService.login(request));
    }

}
