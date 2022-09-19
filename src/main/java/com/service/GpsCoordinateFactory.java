package com.service;

import com.domain.GPSCoordinates;
import org.springframework.stereotype.Service;


@Service
public class GpsCoordinateFactory {

    public GPSCoordinates createGpsCoordinate(int radius, double longitude, double latitude) {
        GPSCoordinates gpsCoordinates = new GPSCoordinates(MathCalculation.roundOff(longitude - calculateDistancetoCoordinate(radius)),
                MathCalculation.roundOff(longitude + calculateDistancetoCoordinate(radius)),
                MathCalculation.roundOff(latitude - calculateDistancetoCoordinate(radius)),
                MathCalculation.roundOff(latitude + calculateDistancetoCoordinate(radius)));
        return gpsCoordinates;
    }

    private double calculateDistancetoCoordinate(int radius) {
        return (radius * (0.01) / 1.1);
    }

}
