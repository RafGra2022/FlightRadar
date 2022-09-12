package com.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class GpsCoordinateService {

    public HashMap<String, Double> terrainAppoint(int radius, double longitude, double latitude) {
        HashMap<String, Double> terrain = new HashMap<>();
        terrain.put("loMin", roundOff(longitude - ((radius * (0.01) / 1.1))));
        terrain.put("loMax", roundOff(longitude + ((radius * (0.01) / 1.1))));
        terrain.put("laMin", roundOff(latitude - ((radius * (0.01) / 1.1))));
        terrain.put("laMax", roundOff(latitude + ((radius * (0.01) / 1.1))));
        return terrain;
    }

    private double roundOff(double number) {
        double scale = (Math.pow(10, 2));
        return Math.round(number * scale) / scale;
    }
}
