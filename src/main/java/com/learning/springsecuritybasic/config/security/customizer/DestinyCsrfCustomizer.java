package com.learning.springsecuritybasic.config.security.customizer;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.stereotype.Component;

@Component
public class DestinyCsrfCustomizer implements Customizer<CsrfConfigurer<HttpSecurity>> {
    @Override
    public void customize(CsrfConfigurer<HttpSecurity> httpSecurity) {
        httpSecurity
                .csrfTokenRequestHandler(csrfTokenRequestAttributeHandler())
                .ignoringRequestMatchers("/welcome", "/register")
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    private CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler() {
        var csrfTokenRequestAttributeHandler = new CsrfTokenRequestAttributeHandler();
        csrfTokenRequestAttributeHandler.setCsrfRequestAttributeName("_csrf");
        return csrfTokenRequestAttributeHandler;
    }
}
