package com.javaschool.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a Stations on wich trains run. Have station name lattitude and longitude. Connected with waypoints.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Stations", schema = "JVS")
public class Station extends BaseEntity {
    /**
     * The name of the station.
     */
    @Column(name = "station_name")
    private String stationName;

    /**
     * the lattitude of the station (need to count distance between stations)
     */
    @Column(name = "lattitude")
    private double latitude;

    /**
     * the longitude of the station (need to count distance between stations)
     */
    @Column(name = "longitude")
    private double longitude;

    /**
     * Waypoints with that station.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "station")
    private List<Waypoint> waypoints;

    public Station(String stationName, double lattitude, double longitude) {
        this.stationName = stationName;
        this.latitude = lattitude;
        this.longitude = longitude;
    }
}
