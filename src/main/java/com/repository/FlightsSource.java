package com.repository;

import com.domain.FlightsDto;
import com.domain.GPSCoordinates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@RequiredArgsConstructor
@Service
public class FlightsSource {

    private final WebClient webClient;

    public FlightsDto getFlights(GPSCoordinates gpsCoordinates) {
         return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("all")
                        .queryParam("lamin", gpsCoordinates.getLaMin())
                        .queryParam("lamax", gpsCoordinates.getLaMax())
                        .queryParam("lomin", gpsCoordinates.getLoMin())
                        .queryParam("lomax", gpsCoordinates.getLoMax())
                        .build())
                .retrieve()
                .bodyToMono(FlightsDto.class).block();
    }

}
