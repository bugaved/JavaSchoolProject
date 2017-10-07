package com.javaschool.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Waypoints", schema = "JVS")
public class Waypoint extends BaseEntity {


    @Column(name = "arrival_time")
    private Date arrivalTime;

    @Column(name = "departure_time")
    private Date departureTime;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Route.class)
    @JoinColumn(name = "station_id")
    private Station station;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Route.class)
    @JoinColumn(name = "route_id")
    private Route route;


}
