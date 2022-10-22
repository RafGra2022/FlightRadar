package com.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightCustomResponse {

    private String distance;
//    private String icao24;
    private String airline;
    private String registration;
    private String aircraftType;
    private String callsign;
    private String originCountry;
    private String position;
//    private String longitude;
//    private String latitude;
    private String baroAltitude;
    private String onGround;
    private String velocity;
    private String trueTrack;
    private String verticalRate;
    private String geoAltitude;

    public boolean isRegistrationPresent(String registration){
        return this.registration.equals(registration);
    }
}
