package com.repository;

import com.domain.FlightsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;


@RequiredArgsConstructor
@Service
public class FlightsSource {

    private final WebClient webClient;

    public FlightsDto getFlights(Map<String,Double> terrain) {
         return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("all")
                        .queryParam("lamin", terrain.get("laMin"))
                        .queryParam("lamax", terrain.get("laMax"))
                        .queryParam("lomin", terrain.get("loMin"))
                        .queryParam("lomax", terrain.get("loMax"))
                        .build())
                .retrieve()
                .bodyToMono(FlightsDto.class).block();
    }

}
