package com.javaschool.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TRAINS")
public class Train extends BaseEntity {


    @Column(name = "name")
    private String name;


    @Column(name = "seats_count")
    private int seatsCount;


    public Train() {
    }

    public Train(String name, int seatsCount) {
        this.name = name;
        this.seatsCount = seatsCount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = seatsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (seatsCount != train.seatsCount) return false;
        return name != null ? name.equals(train.name) : train.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + seatsCount;
        return result;
    }

    @Override
    public String toString() {
        return "Train{" +
                "name='" + name + '\'' +
                ", seatsCount=" + seatsCount +
                '}';
    }
}
