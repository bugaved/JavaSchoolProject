package com.javaschool.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a route which train fallow, have a unique route code, connected
 * with waypoints, tickets and trains.
 */
@Data
@Entity
@Table(name = "Routes", schema = "JVS")
public class Route extends BaseEntity {

    @Column(name = "code")
    private String code;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
    private List<Ticket> tickets;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
    private List<Waypoint> waypoints;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
    private List<Train> trains;


}
