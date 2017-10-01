package com.javaschool.model;


import javax.persistence.*;

@Entity
@Table(name = "TICKETS")
public class Ticket extends BaseEntity {

    @Column(name = "route_code")
    private String routeCode;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
