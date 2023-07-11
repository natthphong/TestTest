package com.auth2.azuread.controller.rest;

import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
public class AuthenticationGithub implements Authentication {
    private List<? extends GrantedAuthority> authorities;

    private Object credentials;

    private Object details;

    private Object principal;

    private boolean authenticated;

    private String name;

    private Object Attributes;
    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
            this.authenticated = isAuthenticated;
    }


}
