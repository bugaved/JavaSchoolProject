package com.javaschool.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Stations", schema = "JVS")
public class Station extends BaseEntity {

    @Column(name = "station_name")
    private String stationName;

    @Column(name = "lattitude")
    private double lattitude;

    @Column(name = "longitude")
    private double longitude;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "station")
    private List<Waypoint> waypoints;


}
