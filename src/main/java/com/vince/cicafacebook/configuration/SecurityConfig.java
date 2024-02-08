package com.vince.cicafacebook.configuration;

import com.vince.cicafacebook.configuration.jwt.CustomJwt;
import com.vince.cicafacebook.configuration.jwt.CustomJwtConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.cors(Customizer.withDefaults())
                .authorizeHttpRequests(authorize->authorize.anyRequest().authenticated())
                .oauth2ResourceServer(oauth2->oauth2.jwt(
                        jwt->jwt.jwtAuthenticationConverter(customJwtConverter())
                ));
        return httpSecurity.build();
    }

    @Bean
    public Converter<Jwt, CustomJwt> customJwtConverter() {
        return new CustomJwtConverter();
    }
}
