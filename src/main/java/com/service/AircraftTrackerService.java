package com.service;

import com.controller.FlightCustomResponse;
import com.controller.FlightsCustomMapper;
import com.domain.FlightsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftTrackerService {

    private final FlightsFinderService flightsFinderService;
    private final FlightsCustomMapper flightsCustomMapper;

    public FlightCustomResponse getAircraftByRegistration(String registration, int radius, double longitude, double latitude) {
        FlightsDto flightsDto = flightsFinderService.getFlights(radius, longitude, latitude);
        List<FlightCustomResponse> flights = flightsCustomMapper
                .mapToCustomResponse(flightsDto, longitude, latitude)
                .getFlights()
                .stream()
                .filter(flight -> flight.isRegistrationPresent(registration))
                .toList();
        if (flights.isEmpty()) {
            return new FlightCustomResponse();
        }
        return flights.get(0);
    }

}
