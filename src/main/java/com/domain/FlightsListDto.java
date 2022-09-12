package com.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@JsonIgnoreProperties
@Setter
@Getter
@Component
public class FlightsListDto {

    private List<List<String>> states;
}
