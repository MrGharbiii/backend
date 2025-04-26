// src/main/java/com/slimhealthy/config/SwaggerConfig.java
package com.slimhealthy.slimhealthy_backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SlimHealthy API")
                        .version("1.0")
                        .description("Health Management System API"));
    }
}