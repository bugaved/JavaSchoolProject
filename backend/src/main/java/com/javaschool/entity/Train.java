package com.javaschool.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Trains")
public class Train extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "seats_count")
    private int seatsCount;

    @Column(name = "is_highspeed")
    private boolean isHighspeed;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Route.class)
    @JoinColumn(name = "route_id")
    private Route route;



}