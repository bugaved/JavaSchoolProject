package com.javaschool.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "WaypointEntity", schema = "JVS")
public class Waypoint extends BaseEntity {
    @Column(name = "waypoint_name")
    private String name;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "station_of_arrival")
    private Station stationOfArrival;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "station_route", joinColumns = {
            @JoinColumn(name = "station_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "route_id",
                    nullable = false, updatable = false)})
    private List<Route> routes;

    public Waypoint() {
    }

    public Waypoint(Date arrivalDate, Station stationOfArrival, List<Route> routes) {
        this.arrivalDate = arrivalDate;
        this.stationOfArrival = stationOfArrival;
        this.routes = routes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Station getStationOfArrival() {
        return stationOfArrival;
    }

    public void setStationOfArrival(Station stationOfArrival) {
        this.stationOfArrival = stationOfArrival;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Waypoint waypoint = (Waypoint) o;

        if (!name.equals(waypoint.name)) return false;
        if (!arrivalDate.equals(waypoint.arrivalDate)) return false;
        if (!stationOfArrival.equals(waypoint.stationOfArrival)) return false;
        return routes.equals(waypoint.routes);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + arrivalDate.hashCode();
        result = 31 * result + stationOfArrival.hashCode();
        result = 31 * result + routes.hashCode();
        return result;
    }
}
