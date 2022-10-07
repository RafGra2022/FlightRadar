package com.repository;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RegistrationImpl implements AircraftProperty {


    @Override
    public String getAircraftProperty(String icao24, WebClient hexApi){
        return hexApi.get()
                .uri(uriBuilder -> uriBuilder
                .path("hex-reg.php")
                .queryParam("hex",icao24)
                .build())
                .retrieve()
                .bodyToMono(String.class).block();
    }


}
