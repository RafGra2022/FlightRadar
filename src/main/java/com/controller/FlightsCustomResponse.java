package com.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
public class FlightsCustomResponse {

    List<FlightCustomResponse> flights;
}
