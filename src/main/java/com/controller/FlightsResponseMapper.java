package com.controller;

import com.domain.FlightProperties;
import com.domain.FlightsListDto;
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


    public List<FlightProperties> mapToFlightProperties(FlightsListDto flightsListDto) {

        List<FlightProperties> listOfFlights = new ArrayList<>();
        if(flightsListDto.getStates()!=null) {
            flightsListDto.getStates().forEach(flight -> {

                FlightProperties flightProperties = new FlightProperties();
                flightProperties.setIcao24(flight.get(0));
                flightProperties.setCallsign(flight.get(1));
                flightProperties.setOriginCountry(flight.get(2));
                flightProperties.setTimePosition(flight.get(3));
                flightProperties.setLastContact(flight.get(4));
                flightProperties.setLongitude(flight.get(5));
                flightProperties.setLatitude(flight.get(6));
                flightProperties.setBaroAltitude(flight.get(7)+"[m]");
                flightProperties.setOnGround(flight.get(8));
                flightProperties.setVelocity(flight.get(9)+"[m/s]");
                flightProperties.setTrueTrack(flight.get(10)+"[rad]");
                flightProperties.setVerticalRate(flight.get(11)+"[m/s]");
                flightProperties.setSensors(flight.get(12));
                flightProperties.setGeoAltitude(flight.get(13)+"[m]");
                flightProperties.setSquawk(flight.get(14));
                flightProperties.setSpi(flight.get(15));
                listOfFlights.add(flightProperties);

            });
        }
        else{
            System.out.println("brak lotów");
            log.info("no Flights in obtained terrain");
        }
        return listOfFlights;
    }


}
