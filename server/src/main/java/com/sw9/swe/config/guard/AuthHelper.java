package com.sw9.swe.config.guard;

import com.sw9.swe.config.security.PrincipalDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthHelper {
    public boolean isAuthenticated() {
        return getAuthentication().isAuthenticated();
    }

    public Long extractStudentRegistrationNumber() {
        return getPrincipalDetails().getRegistrationNumber();
    }

    private PrincipalDetails getPrincipalDetails() {
        return (PrincipalDetails) getAuthentication().getPrincipal();
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
