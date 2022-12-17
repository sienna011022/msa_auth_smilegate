package com.gateway.gatewayserver.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthFilter extends AbstractGatewayFilterFactory<CustomAuthFilter.Config> {
    public CustomAuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            try {
                String authorization = request.getHeaders().get("Authorization").get(0);
                authorization.replace("Bearer", "");
                return chain.filter(exchange);
            } catch (NullPointerException exception) {
                throw new Error("token 이 없습니다");
            }
        });
    }

    public static class Config {

    }
}
