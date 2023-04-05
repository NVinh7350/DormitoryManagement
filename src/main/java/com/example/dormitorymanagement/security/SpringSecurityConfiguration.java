package com.example.dormitorymanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // @formatter:off
                http.authorizeRequests((authz) -> authz
                        .antMatchers("/").hasRole("USER")
                        .antMatchers("/admin/**").hasRole("ADMIN")
                )
                .formLogin(withDefaults());
        return http.build();
    }
}
