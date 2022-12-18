package com.auth.user.web.service;

import com.auth.user.domain.Member;
import com.auth.user.domain.MemberRepository;
import com.auth.user.common.exception.NotFoundUserException;
import com.auth.user.web.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    private final FeignCommunicator authCommunicator;

    public Map<String,String> login(LoginRequest request) {
        Member member = findMember(request);
        member.isValid(request);
        return authCommunicator.createJwt(request);
    }

    @Transactional
    public Member findMember(LoginRequest request){
        return memberRepository.findByMemberId(request.getMemberId())
            .orElseThrow(() -> new NotFoundUserException());
    }
}
