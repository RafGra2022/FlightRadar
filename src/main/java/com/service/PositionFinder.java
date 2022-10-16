package com.service;

import com.domain.AddressProperties;
import com.repository.GPSPositionSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionFinder {

    private final GPSPositionSource gpsPositionSource;

    private List<AddressProperties> getPosition(String lat, String lon) {
        return gpsPositionSource
                .getPosition(lat, lon)
                .getResults()
                .stream()
                .flatMap(components -> components.getAddress_components().stream())
                .toList();
    }

    public String getLocality(String lat, String lon) {
        return getPosition(lat, lon)
                .stream()
                .filter(properties -> properties.getTypes().contains("locality"))
                .findFirst()
                .orElseThrow()
                .getLong_name();
    }

    public String getVoivodeship(String lat, String lon) {
        String voivodeship = getPosition(lat, lon).stream().filter(properties -> properties.getTypes().contains("administrative_area_level_1")).findFirst().orElseThrow().getLong_name();
        List<String> fullNameOfVoivodeship = Arrays.stream(voivodeship.split("\\s")).toList();
        return fullNameOfVoivodeship
                .stream()
                .findFirst()
                .orElseThrow();
    }

    public String getCountry(String lat, String lon){
        return getPosition(lat, lon)
                .stream()
                .filter(properties -> properties.getTypes().contains("country"))
                .findFirst()
                .orElseThrow()
                .getShort_name();
    }
}
