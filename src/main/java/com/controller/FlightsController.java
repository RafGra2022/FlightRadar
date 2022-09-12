package com.controller;

import com.domain.FlightProperties;
import com.service.FlightsFinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/flights")
public class FlightsController {

    private final FlightsFinderService flightsFinderService;

    @GetMapping(path = "/inFlight")
    public List<FlightProperties> getLiveFlights(@RequestParam int radius, double longitude, double latitude)  {
        return flightsFinderService.getFlights(radius,longitude,latitude);
    }

}
