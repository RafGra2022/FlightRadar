package com.controller;

import com.domain.FlightsDto;
import com.service.FlightsFinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/flights")
public class FlightsController {

    private final FlightsFinderService flightsFinderService;
    private final FlightsResponseMapper flightsResponseMapper;
    private final FlightsCustomMapper flightsCustomMapper;

    @GetMapping(path = "/active-flights")
    public FlightsResponse getActiveFlights(@RequestParam int radius, @RequestParam double longitude, @RequestParam double latitude)  {
        FlightsDto flights = flightsFinderService.getFlights(radius, longitude, latitude);
        return flightsResponseMapper.mapToFlightsResponse(flights);
    }
    @GetMapping(path = "/custom-flights")
    public FlightsCustomResponse getCustomFlights(@RequestParam int radius, @RequestParam double longitude, @RequestParam double latitude){
        FlightsDto flights = flightsFinderService.getFlights(radius, longitude, latitude);
        return flightsCustomMapper.mapToFlightsResponse(flights,longitude,latitude);
    }


}
