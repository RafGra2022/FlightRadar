package com.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Repository
public class AircraftTypeRepository implements AircraftAttributeRepository {

    private final WebClient hexApi;

    @Override
    public String getAircraftAttributes(String aircraftId) {
        return hexApi.get()
                .uri(uriBuilder -> uriBuilder
                        .path("hex-type.php")
                        .queryParam("hex",aircraftId)
                        .build())
                .retrieve()
                .bodyToMono(String.class).block();
    }
}
