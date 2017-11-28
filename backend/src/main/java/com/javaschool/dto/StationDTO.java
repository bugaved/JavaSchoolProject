package com.javaschool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StationDTO {

    private String stationName;
    private double latitude;
    private double longitude;
}
