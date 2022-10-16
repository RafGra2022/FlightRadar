package com.controller;

import com.domain.FlightsDto;
import com.domain.PositionDto;
import com.repository.GPSPositionSource;
import com.service.FlightsFinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/flights")
public class FlightsController {

    private final FlightsFinderService flightsFinderService;
    private final FlightsResponseMapper flightsResponseMapper;
    private final FlightsCustomMapper flightsCustomMapper;
    private final GPSPositionSource gpsPositionSource;

    @GetMapping(path = "/active-flights")
    public FlightsResponse getActiveFlights(@RequestParam int radius, @RequestParam double longitude, @RequestParam double latitude)  {
        FlightsDto flights = flightsFinderService.getFlights(radius, longitude, latitude);
        return flightsResponseMapper.mapToFlightsResponse(flights);
    }
    @GetMapping(path = "/custom-flights")
    public FlightsCustomResponse getCustomFlights(@RequestParam int radius, @RequestParam double longitude, @RequestParam double latitude){
        FlightsDto flights = flightsFinderService.getFlights(radius, longitude, latitude);
        return flightsCustomMapper.mapToCustomResponse(flights,longitude,latitude);
    }

    @GetMapping(path="/test")
    public PositionDto test(){
        return gpsPositionSource.getPosition(String.valueOf(49.98),String.valueOf(21.76));
    }


}
