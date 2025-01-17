package com.flight.adminManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, "/api/user/signUp", "/api/admin/login","/flights/*","/api/admin/reply").permitAll()
                .requestMatchers(HttpMethod.GET,"/flights/getAllflights").permitAll()
                .requestMatchers(HttpMethod.DELETE,"/flights/**").permitAll()
                .requestMatchers(HttpMethod.PUT,"/flights/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin().disable(); // Disable default login form
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}