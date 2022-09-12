package com.service;

import com.domain.FlightsDto;
import com.repository.FlightsSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class FlightsFinderService {

    private final FlightsSource flightsSource;
    private final GpsCoordinateFactory gpsCoordinateFactory;

    public FlightsDto getFlights(int radius, double longitude, double latitude ){
        HashMap<String, Double> gpsCoordinate = gpsCoordinateFactory.createGpsCoordinate(radius, longitude, latitude);
        return flightsSource.getFlights(gpsCoordinate);
    }
}
