package com.airy.ecom.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class OAuthResourceServerConfig {

    private static final String[] WHITE_LIST_URLS = {
            "/api/v1/product/**",
            "/api/v1/inventory/**"
            //"/api/v1/cart/**"
    };


    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) throws Exception {
        return http
                .csrf(csrfSpec -> csrfSpec.disable())
                .cors(corsSpec -> corsSpec.disable())
                .authorizeExchange(authorizer -> {
                    authorizer.pathMatchers(WHITE_LIST_URLS).permitAll();
                    authorizer.anyExchange().authenticated();
                })
                .oauth2ResourceServer(oAuth2ResourceServerSpec -> oAuth2ResourceServerSpec.jwt(Customizer.withDefaults()))
                .build();
    }


    public void test(){
        StringBuilder sb = new StringBuilder();

        sb.append("abcdsrs,");

        ArrayList<String> list = (ArrayList<String>) Arrays.asList(sb.toString().split(","));

        System.out.print(list);
    }
}
