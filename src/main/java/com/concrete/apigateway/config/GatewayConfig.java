package com.concrete.apigateway.config;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RefreshScope  // Enables runtime config refresh
@Configuration
public class GatewayConfig  {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("userservice", r -> r.path("/users/**")
                        .uri("lb://USERSERVICE"))
                .route("orderservice", r -> r.path("/orders/**")
                        .uri("lb://ORDERSERVICE"))
                .route("chatservice", r -> r.path("/chats/**")
                        .uri("lb://CHATSERVICE"))
                .route("productservice", r -> r.path("/products/**")
                        .uri("lb://PRODUCTSERVICE"))
                .route("infoservice", r -> r.path("/info/**")
                        .uri("lb://INFOSERVICE"))
                .route("notificationservice", r -> r.path("/notify/**")
                        .uri("lb://NOTIFICATIONSERVICE"))
                .build();
    }
}