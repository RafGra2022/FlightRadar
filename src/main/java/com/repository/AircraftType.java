package com.repository;

import org.springframework.web.reactive.function.client.WebClient;

public class AircraftType implements AircraftProperty {

    @Override
    public String getAircraftProperty(String icao24,WebClient hexApi) {
        return hexApi.get()
                .uri(uriBuilder -> uriBuilder
                        .path("hex-type.php")
                        .queryParam("hex",icao24)
                        .build())
                .retrieve()
                .bodyToMono(String.class).block();
    }
}
