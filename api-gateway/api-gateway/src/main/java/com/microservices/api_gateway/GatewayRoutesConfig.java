package com.microservices.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("item-service", r -> r.path("/items/**")
                        .uri("http://item-service:8081"))
                .route("order-service", r -> r.path("/orders/**")
                        .uri("http://order-service:8082"))
                .route("payment-service", r -> r.path("/payments/**")
                        .uri("http://payment-service:8083"))
                .build();
    }
}
