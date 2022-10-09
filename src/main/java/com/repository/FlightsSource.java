package com.repository;

import com.domain.FlightsDto;
import com.domain.GPSCoordinates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;


@RequiredArgsConstructor
@Repository
public class FlightsSource {

    private final WebClient openSky;

    public FlightsDto getFlights(GPSCoordinates gpsCoordinates) {
         return openSky.get()
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
