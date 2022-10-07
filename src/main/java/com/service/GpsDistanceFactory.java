package com.service;

import org.springframework.stereotype.Service;

@Service
public class GpsDistanceFactory {

    public String calculateDistance(double personLon, double personLat, String flightLon, String flightLat) {
        double lonDistance = personLon - Double.parseDouble(flightLon) ;
        double latDistance = personLat - Double.parseDouble(flightLat);
        return String.valueOf(MathCalculation.roundOff(Math.sqrt(Math.pow(lonDistance,2)+Math.pow(latDistance,2))*111));
    }

}
