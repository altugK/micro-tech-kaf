package com.kafein.producer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenApi(@Value("${application-description}") String description,
                                 @Value("${application-version}") String version) {
        return new OpenAPI()
                .info(new Info()
                        .title("User Follower API")
                        .version("v1")
                        .description("User Follower API"));
    }
}
