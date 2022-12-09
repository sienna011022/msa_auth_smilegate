package com.auth.user;

import com.auth.user.domain.EncryptFactory;
import com.auth.user.domain.EncryptResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EncryptTest {
    private static final int LENGTH_OF_SHA_256 = 64;
    private static final int LENGTH_OF_SALT = 16;

    @Test
    void encrypt() {
        EncryptResult result = EncryptFactory.encrypt("abcd");
        Assertions.assertThat(result.encryptPassword().length()).isEqualTo(LENGTH_OF_SHA_256);
        Assertions.assertThat(result.salt().length()).isEqualTo(LENGTH_OF_SALT);
    }
}
