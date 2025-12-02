package com.ec.akirafinanzas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Deshabilita CSRF para pruebas con Postman o navegador
                .authorizeHttpRequests()
                .anyRequest().permitAll(); // Permite todas las rutas
        return http.build();
    }
}
