package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguartion {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://opensky-network.org/api/states/")
                .build();
    }


}
