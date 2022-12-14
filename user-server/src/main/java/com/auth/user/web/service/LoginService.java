package com.auth.user.web.service;

import com.auth.user.domain.Member;
import com.auth.user.domain.MemberRepository;
import com.auth.user.exception.NotFoundUserException;
import com.auth.user.web.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    private final FeignCommunicator authCommunicator;

    public String login(LoginRequest request) {
        Member member = findMember(request);
        member.isValid(request);
        return authCommunicator.createJwt(request);
    }

    @Transactional
    public Member findMember(LoginRequest request){
        return memberRepository.findByMemberId(request.getMemberId())
            .orElseThrow(() -> new NotFoundUserException("일치하는 회원정보가 없습니다"));
    }
}
