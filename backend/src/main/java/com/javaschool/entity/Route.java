package com.javaschool.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a route which train fallow, have a unique route code, connected
 * with waypoints, tickets and trains.
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "Routes", schema = "JVS")
public class Route extends BaseEntity {

    /**
     * The code of the route (letters and numbers).
     */
    @Column(name = "code")
    private String code;

    /**
     * Tickets with that route
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
    private List<Ticket> tickets;

    /**
     * The waypoints (entities stations and arrival/departure time) of the route
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
    private List<Waypoint> waypoints;

    /**
     * The trains with that route.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "route")
    private List<Train> trains;


    public Route(String code) {
        this.code = code;
    }
}
