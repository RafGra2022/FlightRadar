package com.service;

import com.domain.FlightsDto;
import com.domain.GPSCoordinates;
import com.repository.FlightsSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.util.GpsCoordinateUtil.createGpsCoordinate;

@RequiredArgsConstructor
@Service
public class FlightsFinderService {

    private final FlightsSource flightsSource;

    public FlightsDto getFlights(int radius, double longitude, double latitude ){
        GPSCoordinates gpsCoordinates = createGpsCoordinate(radius, longitude, latitude);
        return flightsSource.getFlights(gpsCoordinates);
    }
}
