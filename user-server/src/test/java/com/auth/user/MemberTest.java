package com.auth.user;

import com.auth.user.domain.Member;
import com.auth.user.domain.Role;
import com.auth.user.web.dto.UserCreateRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MemberTest {

    @Test
    @DisplayName("회원가입을 한다")
    void create_user() {
        UserCreateRequest request = UserCreateRequest.builder()
            .memberId("sienna1022")
            .name("kimSungYoon")
            .email("sienna011022@naver.com")
            .password("abcd")
            .role(Role.GUEST)
            .build();

        Assertions.assertThat(request.toMember()).isInstanceOf(Member.class);
    }

    @Test
    @DisplayName("아이디를 입력하지 않으면 예외 발생")
    void create_user_exception(){
        UserCreateRequest errorRequest = UserCreateRequest.builder()
            .memberId(null)
            .name("kimSungYoon")
            .email("sienna011022@naver.com")
            .password("abcd")
            .role(Role.GUEST)
            .build();

        assertThatThrownBy(() -> errorRequest.toMember()).isInstanceOf(IllegalArgumentException.class);
    }


}
