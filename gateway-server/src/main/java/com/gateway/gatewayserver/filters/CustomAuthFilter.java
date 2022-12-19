package com.gateway.gatewayserver.filters;

import com.gateway.gatewayserver.exception.NotFoundTokenException;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthFilter extends AbstractGatewayFilterFactory<CustomAuthFilter.Config> {

    private static final String AUTHORIZATION = "Authorization";
    private static final String TYPE_OF_AUTHORIZATION = "Bearer";
    private static final String REPLACE_AUTHORIZATION = "";
    private static final int TOKEN = 0;

    public CustomAuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            try {
                String authorization = request.getHeaders().get(AUTHORIZATION).get(TOKEN);
                authorization.replace(TYPE_OF_AUTHORIZATION, REPLACE_AUTHORIZATION);
                return chain.filter(exchange);
            } catch (NullPointerException exception) {
                throw new NotFoundTokenException();
            }
        });
    }

    public static class Config {

    }
}
