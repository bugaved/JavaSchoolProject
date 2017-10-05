package com.javaschool.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "StationEntity", schema = "JVS")
public class Station {
    @Column(name = "station_name")
    private String stationName;


    public Station() {
    }


    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}