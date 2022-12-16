package com.auth.authserver;

import com.auth.authserver.domain.Token;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenTest {

    @Test
    void create(){
        Token token  = new Token("thisisFakeJWTToken");
        assertThat(token.uuid().toString().length()).isEqualTo(36);
    }
}
