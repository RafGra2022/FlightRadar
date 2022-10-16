package com.controller;

import com.domain.FlightsDto;
import com.repository.AircraftAttributeRepository;
import com.service.PositionFinder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.util.GpsDistanceCalculator.calculateDistance;

@Slf4j
@RequiredArgsConstructor
@Component
public class FlightsCustomMapper {

    private final AircraftAttributeRepository aircraftRegistrationRepository;
    private final AircraftAttributeRepository aircraftTypeRepository;
    private final AircraftAttributeRepository airlineNameRepository;
    private final PositionFinder positionFinder;

    public FlightsCustomResponse mapToCustomResponse(FlightsDto flightsListDto, double longitude, double latitude) {
        if (flightsListDto.getStates() == null) {
            log.info("no Flights in obtained terrain");
            return new FlightsCustomResponse(new ArrayList<>());
        }
        List<FlightCustomResponse> listOfFlights = flightsListDto.getStates().stream()
                .map(flight -> mapToFlightCustomResponse(longitude, latitude, flight))
                .toList();
        return new FlightsCustomResponse(listOfFlights);
    }

    private FlightCustomResponse mapToFlightCustomResponse(double longitude, double latitude, List<String> flight) {
        FlightCustomResponse flightCustomResponse = new FlightCustomResponse();
        flightCustomResponse.setDistance(calculateDistance(longitude, latitude, flight.get(5), flight.get(6)) + "km");
//        flightCustomResponse.setIcao24(flight.get(0));
        flightCustomResponse.setAirline(airlineNameRepository.getAircraftAttributes(flight.get(0)));
        flightCustomResponse.setRegistration(aircraftRegistrationRepository.getAircraftAttributes(flight.get(0)));
        flightCustomResponse.setAircraftType(aircraftTypeRepository.getAircraftAttributes(flight.get(0)));
        flightCustomResponse.setCallsign(flight.get(1));
        flightCustomResponse.setOriginCountry(flight.get(2));
        flightCustomResponse.setPosition(positionFinder.getLocality(flight.get(6),flight.get(5))+", "
                +positionFinder.getVoivodeship(flight.get(6),flight.get(5))+", "
                +positionFinder.getCountry(flight.get(6),flight.get(5)));
//        flightCustomResponse.setLongitude(flight.get(5));
//        flightCustomResponse.setLatitude(flight.get(6));
        flightCustomResponse.setBaroAltitude(flight.get(7) + " m");
        flightCustomResponse.setOnGround(flight.get(8));
        flightCustomResponse.setVelocity(flight.get(9) + " m/s");
        flightCustomResponse.setTrueTrack(flight.get(10) + " rad ");
        flightCustomResponse.setVerticalRate(flight.get(11) + " m/s");
        flightCustomResponse.setGeoAltitude(flight.get(13) + " m");
        return flightCustomResponse;
    }
}
