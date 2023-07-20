package com.auth2.azuread.controller.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public  class   Constant{


    @Value("${app.namespace}")
    public String namespace;
}
