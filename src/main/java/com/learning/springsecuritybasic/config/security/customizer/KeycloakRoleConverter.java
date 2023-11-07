package com.learning.springsecuritybasic.config.security.customizer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    private static final String REALM_ACCESS = "realm_access";
    private static final String ROLES = "roles";
    private static final String SPRING_ROLE_PREFIX = "ROLE_";

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Map<String, Object> claims = jwt.getClaims();
        Map<String, Object> realAccess = getRealAccess(claims);

        return getRoles(realAccess).stream()
                .map(role -> SPRING_ROLE_PREFIX + role)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    private List<String> getRoles(Map<String, Object> realAccess) {
        Object roles = realAccess.get(ROLES);
        if(roles instanceof List) {
            return (List<String>) roles;
        }
        return List.of();
    }

    private Map<String, Object>  getRealAccess(Map<String, Object> claims) {
        Object realAccessAsObject = claims.get(REALM_ACCESS);
        if(realAccessAsObject instanceof Map) {
            return (Map<String, Object>) realAccessAsObject;
        }
        return Map.of();
    }
}
