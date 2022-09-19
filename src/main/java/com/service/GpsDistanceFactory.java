package com.service;

import org.springframework.stereotype.Service;

@Service
public class GpsDistanceFactory {

    public String calculateDistance(double personLon, double personLat, String flightLon, String flightLat) {
        double a = personLon - Double.parseDouble(flightLon) ;
        double b = personLat - Double.parseDouble(flightLat);
        return String.valueOf(MathCalculation.roundOff(Math.sqrt(Math.pow(a,2)+Math.pow(b,2))*111));
    }

}
