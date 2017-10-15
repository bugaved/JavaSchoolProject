package com.javaschool.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Waypoints", schema = "JVS")
public class Waypoint extends BaseEntity {


    @Column(name = "arrival_time")
    private Date arrivalTime;

    @Column(name = "departure_time")
    private Date departureTime;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Station.class)
    @JoinColumn(name = "station_id")
    private Station station;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Route.class)
    @JoinColumn(name = "route_id")
    private Route route;
}
