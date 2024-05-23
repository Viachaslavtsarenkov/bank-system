package com.tsarankou.gateway.config;

import com.tsarankou.gateway.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor

public class RouterConfig {

    private final JwtAuthenticationFilter filterFactory;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/client")
                        .or()
                        .path("/auth")
                        .or().path("/account/transfer").filters(f -> f.filter(filterFactory))
                        .uri("lb://client-service"))
//                .route(p -> p
//                        .path("/auth").filters(f -> f.filter(filterFactory))
//                        .uri("lb://client-service"))
                .route(p -> p
                        .path("/account/**").filters(f -> f.filter(filterFactory))
                        .uri("lb://bank-processor"))
                .build();
    }
}
