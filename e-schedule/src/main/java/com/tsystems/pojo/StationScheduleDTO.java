package com.tsystems.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * This is Data Transport object that returns schedule information for requred station
 */
@Getter
@Setter
@EqualsAndHashCode
public class StationScheduleDTO {

    private int waypointId;
    private String code;
    private Date arrivalTime;
    private Date departureTime;
    private String convertedArrivalTime;
    private String convertedDepartureTime;
    private String stationName;
    private String firstStation;
    private String lastStation;
}
