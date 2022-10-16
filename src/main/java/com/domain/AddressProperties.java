package com.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressProperties {

    private String long_name;
    private String short_name;
    private List<String> types;
}
