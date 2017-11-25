package com.javaschool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by bugav on 25.11.2017.
 */
@Getter
@Setter
@AllArgsConstructor
public class StationDTO {

    private String stationName;
    private double latitude;
    private double longitude;
}
