package com.auth.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByMemberId(String memberId);

    Boolean existsByMemberId(String memberId);
}
