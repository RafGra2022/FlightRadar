package com.repository;

import com.domain.PositionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Service
public class GPSPositionSource {

    private final WebClient geocodingApi;

    public PositionDto getPosition(){
        return geocodingApi.get()
                .uri(uriBuilder -> uriBuilder
                        .path("json")
                        .queryParam("latlng","49.979722, 21.89583")
                        .build())
                .retrieve()
                .bodyToMono(PositionDto.class).block();
    }
}
