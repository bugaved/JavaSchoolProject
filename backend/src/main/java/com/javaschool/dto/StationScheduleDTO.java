package com.javaschool.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * This is Data Transport object that returns schedule information for requred station
 */
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
                                @FieldResult(name = "arrivalTime", column = "arrival_time"),
                                @FieldResult(name = "departureTime", column = "departure_time"),
                                @FieldResult(name = "firstStation", column = "s_name_first"),
                                @FieldResult(name = "lastStation", column = "s_name_last"),
                        }
                )
        }
)
@Getter
@Setter
@EqualsAndHashCode(exclude = "waypointId")
public class StationScheduleDTO implements Serializable {

    @Id
    private int waypointId;
    private String code;
    private Date arrivalTime;
    private Date departureTime;
    private String stationName;
    private String firstStation;
    private String lastStation;

    public StationScheduleDTO() {
    }

    public StationScheduleDTO(int waypointId, String code, Date arrivalTime, Date departureTime, String stationName, String firstStation, String lastStation) {
        this.waypointId = waypointId;
        this.code = code;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.stationName = stationName;
        this.firstStation = firstStation;
        this.lastStation = lastStation;
    }
}
