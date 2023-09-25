package com.auth2.azuread.controller.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;


@Data
@AllArgsConstructor
public class Auth implements Authentication {
    List<Auth.Authorities> authorities;

    Object credentials;

    Object details;

    Object principal;

    boolean isAuthenticated;

    String name;




    @Data
    public static class Authorities implements GrantedAuthority {

        private static final long serialVersionUID = 1L;

        private String authority;
        public Authorities(String authority) {
            this.authority = authority;
        }

        public Authorities() {
            super();
        }


    }
}
