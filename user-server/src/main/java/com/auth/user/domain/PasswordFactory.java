package com.auth.user.domain;

import com.auth.user.exception.IllegalPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class PasswordFactory {
    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public static String encryptPassword(String password) {
        return PASSWORD_ENCODER.encode(password);
    }

    public static boolean isValid(String inputPassword, String savedPassword) {
        if (!PASSWORD_ENCODER.matches(inputPassword, savedPassword)) {
            throw new IllegalPasswordException("비밀번호가 일치하지 않습니다");
        }
        return true;

    }
}
