package com.javaschool.entity.view;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TrainsStationsView {

    private String code;
    private String stationFrom;
    private String stationTo;
    private Date departureDate;
    private Date arrivalDate;
    private int seatsCount;

}
