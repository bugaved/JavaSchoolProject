package com.javaschool.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@SqlResultSetMapping(
        name = "wayPointStationsResult",
        entities = {
                @EntityResult(
                        entityClass = TrainsStationsDTO.class,
                        fields = {
                                @FieldResult(name = "code", column = "code"),
                                @FieldResult(name = "stationName", column = "station_name"),
                                @FieldResult(name = "departureTime", column = "departure_time"),
                                @FieldResult(name = "arrivalTime", column = "arrival_time"),
                                @FieldResult(name = "trainName", column = "name"),
                                @FieldResult(name = "seatsCount", column = "seats_count")
                        }
                )
        }
)
public class WaypointsStationsDTO {
    @Id
    private String code;
    private String stationName;
    private String trainName;
    private Date departureTime;
    private Date arrivalTime;
    private int seatsCount;
}
