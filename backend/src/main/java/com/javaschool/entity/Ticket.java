package com.javaschool.entity;


import lombok.*;

import javax.persistence.*;
@Data
@Entity
@Table(name = "Tickets")
public class Ticket extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Route.class)
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    public Ticket() {
    }

    public Ticket(Route route, User user) {
        this.route = route;
        this.user = user;
    }
}
