package com.auth.user;

import com.auth.user.domain.Member;
import com.auth.user.domain.PasswordFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordFactoryTest {


    private static final int LENGTH_OF_ENCODE = 60;

    @Test
    void encrypt() {
        String result = PasswordFactory.encryptPassword("1234");
        Assertions.assertThat(result.length()).isEqualTo(LENGTH_OF_ENCODE);
    }

    @Test
    void isValid() {
        String inputPassword = "1234";
        Member member = MemberFixture.memberCreateWithPassword(inputPassword);
        PasswordFactory.isValid(inputPassword, member.getPassword());
    }
}
