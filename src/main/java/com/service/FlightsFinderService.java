package com.service;


import com.controller.FlightsResponseMapper;
import com.controller.FlightsWebClient;
import com.domain.FlightProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FlightsFinderService {

    private final FlightsWebClient flightsWebClient;
    private final FlightsResponseMapper flightsResponseMapper;
    private final GpsCoordinateService gpsCoordinateService;

    public List<FlightProperties> getFlights(int radius, double longitude, double latitude ){
        return flightsResponseMapper.mapToFlightProperties(flightsWebClient.webClientInit(gpsCoordinateService.terrainAppoint(radius,longitude,latitude)));
    }
}
