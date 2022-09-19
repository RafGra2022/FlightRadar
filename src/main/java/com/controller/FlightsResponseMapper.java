package com.controller;

import com.domain.FlightsDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
@Getter
public class FlightsResponseMapper {


    public FlightsResponse mapToFlightsResponse(FlightsDto flightsListDto) {

        List<FlightResponse> listOfFlights = new ArrayList<>();
        if(flightsListDto.getStates()!=null) {
            flightsListDto.getStates().forEach(flight -> {

                FlightResponse flightResponse = new FlightResponse();
                flightResponse.setIcao24(flight.get(0));
                flightResponse.setCallsign(flight.get(1));
                flightResponse.setOriginCountry(flight.get(2));
                flightResponse.setTimePosition(flight.get(3));
                flightResponse.setLastContact(flight.get(4));
                flightResponse.setLongitude(flight.get(5));
                flightResponse.setLatitude(flight.get(6));
                flightResponse.setBaroAltitude(flight.get(7)+" m");
                flightResponse.setOnGround(flight.get(8));
                flightResponse.setVelocity(flight.get(9)+" m/s");
                flightResponse.setTrueTrack(flight.get(10)+" rad ");
                flightResponse.setVerticalRate(flight.get(11)+" m/s");
                flightResponse.setSensors(flight.get(12));
                flightResponse.setGeoAltitude(flight.get(13)+" m");
                flightResponse.setSquawk(flight.get(14));
                flightResponse.setSpi(flight.get(15));
                listOfFlights.add(flightResponse);

            });
        }
        else{
            System.out.println("brak lotów");
            log.info("no Flights in obtained terrain");
        }
        return new FlightsResponse(listOfFlights);
    }

}
