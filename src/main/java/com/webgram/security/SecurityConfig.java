package com.webgram.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthentictaionFilter jwtAuthentictaionFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.authorizeHttpRequests().requestMatchers("/api/webgram/v1/**").permitAll();
        httpSecurity.authorizeHttpRequests().requestMatchers("/api/webgram/v1/**/**").permitAll();
        httpSecurity.authorizeHttpRequests().requestMatchers("/api/webgram/v1/auth/**").hasRole("USER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/api/webgram/v1/auth/**").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
        httpSecurity.authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthentictaionFilter, UsernamePasswordAuthenticationFilter.class);

       return httpSecurity.build();
    }
}
