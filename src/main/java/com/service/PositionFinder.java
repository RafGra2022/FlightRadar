package com.service;

import com.domain.AddressProperties;
import com.repository.GPSPositionSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PositionFinder {

    private final GPSPositionSource gpsPositionSource;

    public String getLocality(String lat, String lon) {
        return getPosition(lat, lon)
                .filter(properties -> properties.getTypes().contains("locality"))
                .findFirst()
                .orElseThrow()
                .getLong_name();
    }

    public String getVoivodeship(String lat, String lon) {
        String voivodeship = getPosition(lat, lon).filter(properties -> properties.getTypes().contains("administrative_area_level_1")).findFirst().orElseThrow().getLong_name();
        String[] fullNameOfVoivodeship = voivodeship.split("\\s");
        return fullNameOfVoivodeship[0];
    }

    public String getCountry(String lat, String lon) {
        return getPosition(lat, lon)
                .filter(properties -> properties.getTypes().contains("country"))
                .findFirst()
                .orElseThrow()
                .getShort_name();
    }

    private Stream<AddressProperties> getPosition(String lat, String lon) {
        return gpsPositionSource
                .getPosition(lat, lon)
                .getResults()
                .stream()
                .flatMap(components -> components.getAddress_components().stream());
    }
}
