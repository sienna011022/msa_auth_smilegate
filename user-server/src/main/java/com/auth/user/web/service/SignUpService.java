package com.auth.user.web.service;

import com.auth.user.domain.Member;
import com.auth.user.domain.MemberRepository;
import com.auth.user.common.exception.ExistsUserException;
import com.auth.user.web.dto.UserCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final MemberRepository memberRepository;

    @Transactional
    public void createUser(UserCreateRequest request) {
        findMember(request.getMemberId());
        Member requestMember = request.toMember();
        memberRepository.save(requestMember);
    }

    @Transactional(readOnly = true)
    public void findMember(String memberId) {
        if (memberRepository.existsByMemberId(memberId)) {
            throw new ExistsUserException();
        }
    }
}
