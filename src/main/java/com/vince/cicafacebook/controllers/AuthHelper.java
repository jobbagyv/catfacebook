package com.vince.cicafacebook.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthHelper {
    public String getAuthUserId(){
        final DefaultOidcUser user = (DefaultOidcUser) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return user.getPreferredUsername();
    }
}
