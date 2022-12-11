package com.auth.user.domain;

import com.auth.user.web.dto.LoginRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static org.springframework.util.Assert.hasText;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tbl_member")
public class Member extends BaseEntity {

    @Column(nullable = false, length = 20, unique = true)
    private String memberId;

    @Column(length = 64)
    private String password;

    @Column(length = 20)
    private String name;

    @Column(nullable = false, length = 30, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;


    @Builder
    private Member(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String memberId, String password, String name, String email, Role role) {
        super(id, createdAt, updatedAt);

        hasText(memberId, "아이디를 입력하세요");
        hasText(name, "이름을 입력하세요");
        hasText(password, "비밀번호를 입력하세요");
        hasText(email, "이메일을 입력하세요");
        this.memberId = memberId;
        this.password = PasswordFactory.encryptPassword(password);
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public boolean isValid(LoginRequest request){
        return PasswordFactory.isValid(request.getPassword(),this.password);
    }

}
