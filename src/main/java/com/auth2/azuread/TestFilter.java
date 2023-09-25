package com.auth2.azuread;

import com.auth2.azuread.controller.rest.Auth;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.log.LogMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TestFilter implements Filter {


//    public TestFilter(AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//    }
//
//    public TestFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
//        super(authenticationManager, authenticationEntryPoint);
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//       log.info("hello world {}" ,request.getAuthType());
//        List<Auth.Authorities> authorities = new ArrayList<>();
//        authorities.add(new Auth.Authorities("ADMIN"));
//        authorities.add(new Auth.Authorities("BABY"));
//        Auth a = new Auth(authorities,null,null,null,true,"ADMIN");
//        log.info("hello world {}" ,a);
//        SecurityContextHolder.getContext().setAuthentication(a);
//        log.info("hello world {}" ,a);
//        chain.doFilter(request, response);
//    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("hello world {}" ,request.getLocalAddr());
        List<Auth.Authorities> authorities = new ArrayList<>();
        authorities.add(new Auth.Authorities("ROLE_ADMIN"));
        authorities.add(new Auth.Authorities("ROLE_BABY"));
        Auth a = new Auth(authorities,null,null,null,true,"ADMIN");
        log.info("hello world {}" ,a);
        SecurityContextHolder.getContext().setAuthentication(a);
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        authorities.add(new SimpleGrantedAuthority("ROLE_BABY"));
//        Authentication authentication = new UsernamePasswordAuthenticationToken("username", "password", authorities);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        log.info("hello world {}" ,authorities);
        chain.doFilter(request, response);
    }
}
