package com.accenture.nace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("NACE Application").version("1.0").description("Update Nace details")
                    .contact(new Contact().name("Sandeep Nandagiri").email("s.nandagiri@accenture.com")));
    }

}