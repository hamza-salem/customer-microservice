package com.digitinary.customer.customer_microservice.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");



        Info information = new Info()
                .title("Customer Management System API")
                .version("1.0")
                .description("This API exposes endpoints to manage customers.");
        return new OpenAPI().info(information).servers(List.of(server));
    }
}