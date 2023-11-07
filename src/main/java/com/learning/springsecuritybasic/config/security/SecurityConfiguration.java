package com.learning.springsecuritybasic.config.security;

import com.learning.springsecuritybasic.config.security.customizer.DestinyAuth2Customizer;
import com.learning.springsecuritybasic.config.security.customizer.DestinyCsrfCustomizer;
import com.learning.springsecuritybasic.config.security.filter.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class SecurityConfiguration {

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http,
                                                   DestinyAuth2Customizer destinyAuth2Customizer,
                                                   DestinyCsrfCustomizer destinyCsrfCustomizer) throws Exception {
        return http
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(httpSecurityCorsConfig -> httpSecurityCorsConfig.configurationSource(this::corsConfiguration))
                .csrf(destinyCsrfCustomizer)
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> {
                    requests.requestMatchers("/armies/**", "/character/**", "/bluff/**", "/lands/**").authenticated()
                            .requestMatchers("/welcome", "/register", "/performLogin").permitAll();
                })
                .oauth2ResourceServer(destinyAuth2Customizer)
                .build();
    }

    private CorsConfiguration corsConfiguration(HttpServletRequest httpServletRequest) {
        var corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000", "https://web.postman.co"));
        corsConfiguration.setAllowedMethods(List.of("*"));
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(3600L);
        return corsConfiguration;
    }

}
