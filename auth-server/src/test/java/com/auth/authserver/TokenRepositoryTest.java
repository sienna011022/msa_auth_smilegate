package com.auth.authserver;

import com.auth.authserver.domain.Token;
import com.auth.authserver.domain.TokenRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TokenRepositoryTest {
    @Autowired
    TokenRepository tokenRepository;

    @Test
    void create() {
        Token token = new Token("tokenisfake");
        UUID uuid = token.uuid();
        tokenRepository.save(token);
        assertThat(tokenRepository.findById(uuid).get()).isEqualTo(token);
    }

}
