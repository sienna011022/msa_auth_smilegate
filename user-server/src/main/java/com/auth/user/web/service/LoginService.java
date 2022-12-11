package com.auth.user.web.service;

import com.auth.user.domain.Member;
import com.auth.user.domain.MemberRepository;
import com.auth.user.web.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    @Transactional
    public boolean login(LoginRequest request) {
        Member member = memberRepository.findByMemberId(request.getMemberId()).get();
        return member.isValid(request);
    }
}
