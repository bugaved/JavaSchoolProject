package com.javaschool.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Trains")
/**
 * Represents a train, that follows requred route .
 */
public class Train extends BaseEntity {
    /**
     * Name of the train.
     */
    @Column(name = "name")
    private String name;
    /**
     * The number of seats in the train
     */
    @Column(name = "seats_count")
    private int seatsCount;

    /**
     * boolean that show is it fast train or slow one
     */
    @Column(name = "is_highspeed")
    private boolean isHighspeed;

    /**
     * Route which train follows.
     */
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Route.class)
    @JoinColumn(name = "route_id")
    private Route route;



}