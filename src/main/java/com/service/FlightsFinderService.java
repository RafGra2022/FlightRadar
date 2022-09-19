package com.service;

import com.domain.FlightsDto;
import com.domain.GPSCoordinates;
import com.repository.FlightsSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FlightsFinderService {

    private final FlightsSource flightsSource;
    private final GpsCoordinateFactory gpsCoordinateFactory;

    public FlightsDto getFlights(int radius, double longitude, double latitude ){
        GPSCoordinates gpsCoordinates = gpsCoordinateFactory.createGpsCoordinate(radius, longitude, latitude);
        return flightsSource.getFlights(gpsCoordinates);
    }
}
