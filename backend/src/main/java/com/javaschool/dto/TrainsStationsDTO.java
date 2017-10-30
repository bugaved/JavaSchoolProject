package com.javaschool.dto;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@SqlResultSetMapping(
        name="trainStationsResult",
        entities={
                @EntityResult(
                        entityClass=TrainsStationsDTO.class,
                        fields={
                                @FieldResult(name="code", column="code"),
                                @FieldResult(name="stationFrom", column="station_from"),
                                @FieldResult(name="stationTo", column="station_to"),
                                @FieldResult(name="departureTime", column="departure_time"),
                                @FieldResult(name="arrivalTime", column="arrival_time"),
                                @FieldResult(name="seatsCount", column="seats_count")
                        }
                )
        }
)
/**
 * This is Data Transport object that returns root information for train that goes between requred stations
 */
public class TrainsStationsDTO implements Serializable {

    @Id
    private String code;
    private String stationFrom;
    private String stationTo;
    private Date departureTime;
    private Date arrivalTime;
    private int seatsCount;

}
