package com.javaschool.entity;


import lombok.*;

import javax.persistence.*;
/**
 * This is ticket entity, represents tickets that belongs to user and have route_id.
 */
@Data
@Entity
@Table(name = "Tickets")
public class Ticket extends BaseEntity {

    /**
     * The route of the ticket.
     */
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Route.class)
    @JoinColumn(name = "route_id")
    private Route route;

    /**
     * user who have a ticket.
     */
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
