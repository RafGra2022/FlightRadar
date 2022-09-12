package com.controller;

import com.domain.FlightsListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;


@RequiredArgsConstructor
@Service
public class FlightsWebClient {

    @Autowired
    private WebClient webClient;

    public FlightsListDto webClientInit(HashMap<String,Double> terrain) {
         return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("all")
                        .queryParam("lamin", terrain.get("laMin"))
                        .queryParam("lamax", terrain.get("laMax"))
                        .queryParam("lomin", terrain.get("loMin"))
                        .queryParam("lomax", terrain.get("loMax"))
                        .build())
                .retrieve()
                .bodyToMono(FlightsListDto.class).block();
    }

}
