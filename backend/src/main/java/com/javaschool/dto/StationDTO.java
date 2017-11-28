package com.javaschool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * This is Data Transport object that returns information for requred station
 */
@Getter
@Setter
@AllArgsConstructor
public class StationDTO {

    private String stationName;
    private double latitude;
    private double longitude;
}
