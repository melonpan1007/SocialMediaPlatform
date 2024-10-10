/*package com.example.social_media_platform.config;

import com.example.social_media_platform.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/public/**", "/users").permitAll()  // Allow access to /users and public URLs
                        .anyRequest().authenticated()  // All other requests require authentication
                )
                .csrf(csrf -> csrf
                        .disable()  // Disable CSRF for testing with Postman (enable in production)
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Custom login page
                        .permitAll()  // Allow everyone to see the login page
                )
                .logout(logout -> logout
                        .permitAll()  // Allow everyone to logout
                )
                .userDetailsService(userDetailsService);  // Use custom UserDetailsService

        return http.build();
    }
}*/
