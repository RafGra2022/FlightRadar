package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguartion {

    @Bean
    public WebClient openSky() {
        return WebClient.builder()
                .baseUrl("https://opensky-network.org/api/states/")
                .build();
    }

    @Bean
    public WebClient hexApi() {
        return WebClient.builder()
                .baseUrl("https://api.joshdouch.me/")
                .build();
    }

    @Bean
    public WebClient geocodingApi() {
        return WebClient.builder()
                .baseUrl("https://maps.googleapis.com/maps/api/geocode/")
                .build();
    }

}
