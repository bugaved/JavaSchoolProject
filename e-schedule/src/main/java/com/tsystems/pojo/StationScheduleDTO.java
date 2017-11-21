package com.tsystems.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by bugav on 03.11.2017.
 */
@Getter
@Setter
public class StationScheduleDTO {

    private int waypointId;
    private String code;
    private Date requestedTime;
    private String stationName;
    private String firstStation;
    private String lastStation;
}
