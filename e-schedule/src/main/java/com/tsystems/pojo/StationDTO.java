package com.tsystems.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * This is Data Transport object that returns information for requred station
 */
@Getter
@Setter
public class StationDTO {
    private String stationName;
    private double latitude;
    private double longitude;
}
