package com.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class GpsCoordinateFactory {

    public HashMap<String, Double> createGpsCoordinate(int radius, double longitude, double latitude) {
        HashMap<String, Double> terrain = new HashMap<>();
        terrain.put("loMin", roundOff(longitude - calculateDistancetoCoordinate(radius)));
        terrain.put("loMax", roundOff(longitude + calculateDistancetoCoordinate(radius)));
        terrain.put("laMin", roundOff(latitude - calculateDistancetoCoordinate(radius)));
        terrain.put("laMax", roundOff(latitude + calculateDistancetoCoordinate(radius)));
        return terrain;
    }

    private double calculateDistancetoCoordinate(int radius){
        return (radius * (0.01) / 1.1);
    }

    private double roundOff(double number) {
        double scale = (Math.pow(10, 2));
        return Math.round(number * scale) / scale;
    }
}
