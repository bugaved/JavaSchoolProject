package com.javaschool.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * This is waypoints entity, represents the waypoints of route.
 */
@Data
@Entity
@Table(name = "Waypoints", schema = "JVS")
public class Waypoint extends BaseEntity {

    /**
     * Arrival time of the train that follows our route and goes during our waypoins
     */
    @Column(name = "arrival_time")
    private Date arrivalTime;
    /**
     * Departure time of the train that follows our route and goes during our waypoins
     */
    @Column(name = "departure_time")
    private Date departureTime;
    /**
     * Id of station that have our waypoint
     */
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Station.class)
    @JoinColumn(name = "station_id")
    private Station station;
    /**
     * Id of route to which out waypoint belong
     */
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Route.class)
    @JoinColumn(name = "route_id")
    private Route route;
}
