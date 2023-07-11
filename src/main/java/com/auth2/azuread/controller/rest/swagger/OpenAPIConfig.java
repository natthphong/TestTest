package com.auth2.azuread.controller.rest.swagger;


import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${app.dev-url}")
    private String devUrl;

    @Value("${app.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
       Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("tazamaak@gmail.com");
        contact.setName("Natthaphong");
        contact.setUrl("https://www.facebook.com/Tatazaza3a/");

        Info info = new Info()
                .title("Document API")
                .version("1.0")
                .contact(contact);
        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}