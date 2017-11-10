package com.javaschool.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@SqlResultSetMapping(
        name = "stationScheduleResult",
        entities = {
                @EntityResult(
                        entityClass = StationScheduleDTO.class,
                        fields = {
                                @FieldResult(name = "waypointId", column = "waypoint_id"),
                                @FieldResult(name = "code", column = "code"),
                                @FieldResult(name = "stationName", column = "station_name"),
                                @FieldResult(name = "requestedTime", column = "requested_time"),
                                @FieldResult(name = "firstStation", column = "s_name_first"),
                                @FieldResult(name = "lastStation", column = "s_name_last"),
                        }
                )
        }
)
/**
 * This is Data Transport object that returns schedule information for requred station
 */
public class StationScheduleDTO implements Serializable {

    @Id
    private int waypointId;
    private String code;
    private Date requestedTime;
    private String stationName;
    private String firstStation;
    private String lastStation;

    public StationScheduleDTO() {
    }

    public StationScheduleDTO(int waypointId, String code, Date requestedTime, String stationName, String firstStation, String lastStation) {
        this.waypointId = waypointId;
        this.code = code;
        this.requestedTime = requestedTime;
        this.stationName = stationName;
        this.firstStation = firstStation;
        this.lastStation = lastStation;
    }
}
