package com.repository;

import org.springframework.web.reactive.function.client.WebClient;

public interface AircraftProperty {

    String getAircraftProperty(String icao24, WebClient hexApi);
}
