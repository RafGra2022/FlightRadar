package com.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Service
public class AircraftTypeRepository implements AircraftAttributeRepository {

    private final WebClient hexApi;

    @Override
    public String getAircraftAttributes(String icao24) {
        return hexApi.get()
                .uri(uriBuilder -> uriBuilder
                        .path("hex-type.php")
                        .queryParam("hex",icao24)
                        .build())
                .retrieve()
                .bodyToMono(String.class).block();
    }
}
