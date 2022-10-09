package com.util;

import com.domain.GPSCoordinates;


public class GpsCoordinateUtil {

    public static GPSCoordinates createGpsCoordinate(int radius, double longitude, double latitude) {
        return new GPSCoordinates(
                MathCalculation.roundOff(longitude - calculateDistancetoCoordinate(radius)),
                MathCalculation.roundOff(longitude + calculateDistancetoCoordinate(radius)),
                MathCalculation.roundOff(latitude - calculateDistancetoCoordinate(radius)),
                MathCalculation.roundOff(latitude + calculateDistancetoCoordinate(radius)));
    }

    private static double calculateDistancetoCoordinate(int radius) {
        return (radius * (0.01) / 1.1);
    }

}
