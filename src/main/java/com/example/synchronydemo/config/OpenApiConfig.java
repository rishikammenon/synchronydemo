package com.example.synchronydemo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo(){

        return new OpenAPI()
                .info(new Info()
                        .title("Title of my choice")
                        .contact(new Contact()
                                .name("synchronydemo")
                                .url("this url")
                                .email("mmenonrishika90@gmail.com"))
                        .description("This is interview demo project"));
    }
}
