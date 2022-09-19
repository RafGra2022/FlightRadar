package com.controller;

import com.domain.FlightsDto;
import com.service.GpsDistanceFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class FlightsCustomMapper {

    private final GpsDistanceFactory gpsDistanceFactory;

    public FlightsCustomResponse mapToCustomResponse(FlightsDto flightsListDto, double longitude, double latitude) {

        List<FlightCustomResponse> listOfFlights = new ArrayList<>();
        if(flightsListDto.getStates()!=null) {
            flightsListDto.getStates().forEach(flight -> {

                FlightCustomResponse flightCustomResponse = new FlightCustomResponse();
                flightCustomResponse.setDistance(gpsDistanceFactory.calculateDistance(longitude,latitude,flight.get(5),flight.get(6)) + "km");
                flightCustomResponse.setIcao24(flight.get(0));
                flightCustomResponse.setCallsign(flight.get(1));
                flightCustomResponse.setOriginCountry(flight.get(2));
                flightCustomResponse.setLongitude(flight.get(5));
                flightCustomResponse.setLatitude(flight.get(6));
                flightCustomResponse.setBaroAltitude(flight.get(7)+" m");
                flightCustomResponse.setOnGround(flight.get(8));
                flightCustomResponse.setVelocity(flight.get(9)+" m/s");
                flightCustomResponse.setTrueTrack(flight.get(10)+" rad ");
                flightCustomResponse.setVerticalRate(flight.get(11)+" m/s");
                flightCustomResponse.setGeoAltitude(flight.get(13)+" m");
                listOfFlights.add(flightCustomResponse);

            });
        }
        else{
            System.out.println("brak lotów");
            log.info("no Flights in obtained terrain");
        }
        return new FlightsCustomResponse(listOfFlights);
    }

}
