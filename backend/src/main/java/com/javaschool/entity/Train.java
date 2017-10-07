package com.javaschool.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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