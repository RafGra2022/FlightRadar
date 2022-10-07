package com.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties
@Getter
@Setter
public class PositionDto {

    private List<AddressComponents> results;
}
