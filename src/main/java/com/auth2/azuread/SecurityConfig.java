package com.auth2.azuread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextHolderFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

//    @Autowired
//    @Lazy
//    private AuthenticationManager authenticationManager;
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors(cors -> cors.disable())
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/", "/api").permitAll();
                    auth.requestMatchers("/favicon.ico").permitAll();
//                    auth.requestMatchers(new AntPathRequestMatcher("**/admin/**")).hasRole("ADMINZA");
//                    auth.requestMatchers("/role/admin/**").hasRole("ADMIN2");
                    auth.requestMatchers("/**").permitAll();
                    auth.anyRequest().authenticated();
                })
//                .securityContext((s)->s.requireExplicitSave(false))
//                .addFilterBefore(new TestFilter(), SecurityContextHolderFilter.class)
//                .addFilterBefore(new TestFilter(), SecurityContextPersistenceFilter.class)
                .addFilterBefore(new TestFilter(), OAuth2LoginAuthenticationFilter.class)
                .oauth2Login(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }

}