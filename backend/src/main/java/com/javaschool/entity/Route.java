package com.javaschool.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RouteEntity", schema = "JVS")
public class Route extends BaseEntity {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
    private List<Ticket> tickets;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "route")
    private List<Waypoint> waypoints;

    public Route() {
    }

    public Route(List<Ticket> tickets, List<Waypoint> waypoints) {
        this.tickets = tickets;
        this.waypoints = waypoints;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (!tickets.equals(route.tickets)) return false;
        return waypoints.equals(route.waypoints);
    }

    @Override
    public int hashCode() {
        int result = tickets.hashCode();
        result = 31 * result + waypoints.hashCode();
        return result;
    }
}
