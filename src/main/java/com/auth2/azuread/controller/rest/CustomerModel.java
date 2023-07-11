package com.auth2.azuread.controller.rest;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

@Data
@NoArgsConstructor
//@ConfigurationProperties(prefix = "")
public class CustomerModel implements Serializable {
    private String username;
    private String email;
    private Integer age;
}
