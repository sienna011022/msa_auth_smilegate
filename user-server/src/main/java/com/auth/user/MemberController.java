package com.auth.user;

import com.auth.user.web.dto.MemberCreateRequest;
import com.auth.user.web.service.SignUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/members")
public class MemberController {

    private final SignUpService signUpService;

    @PostMapping("/signUp")
    public void signUp(@RequestBody MemberCreateRequest request) {
        signUpService.createCareer(request);
    }

}
