package com.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightCustomResponse {

    private String distance;
    private String icao24;
    private String callsign;
    private String originCountry;
    private String longitude;
    private String latitude;
    private String baroAltitude;
    private String onGround;
    private String velocity;
    private String trueTrack;
    private String verticalRate;
    private String geoAltitude;

}
