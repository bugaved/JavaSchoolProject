package com.tsystems.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by bugav on 03.11.2017.
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
