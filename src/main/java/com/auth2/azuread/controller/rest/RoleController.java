package com.auth2.azuread.controller.rest;


import jakarta.annotation.security.RolesAllowed;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {
    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ADMIN_GET')")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN_GET', 'ROLE_ADMIN_ALL')")
//    @Secured({"ROLE_ADMIN"})
//    @RolesAllowed({ "ROLE_ADMIN" })
    public String getHello() {
        MDC.put("name",SecurityContextHolder.getContext().getAuthentication().getName());
        log.info("{}",SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return "HELLO ADMIN";
    }
}
