package com.auth2.azuread.controller.rest;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
//@ConfigurationProperties(prefix = "")
public class CustomerModel implements Serializable {
    private String username;
    private String email;
    private Integer age;

    @JsonIgnore
    private LocalDate testLocalDate;
    private  LocalDateTime testLocalDateTime;
}
