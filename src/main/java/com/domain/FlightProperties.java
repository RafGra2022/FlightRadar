package com.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightProperties {

    private String icao24;
    private String callsign;
    private String originCountry;
    private String timePosition;
    private String lastContact;
    private String longitude;
    private String latitude;
    private String baroAltitude;
    private String onGround;
    private String velocity;
    private String trueTrack;
    private String verticalRate;
    private String sensors;
    private String geoAltitude;
    private String squawk;
    private String spi;
}
