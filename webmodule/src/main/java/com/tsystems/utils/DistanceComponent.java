package com.tsystems.utils;

import com.javaschool.entity.Station;
import com.javaschool.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by bugav on 27.11.2017.
 */
@Component
public class DistanceComponent {

    @Autowired
    private StationService stationService;


    public long countDistanceBetweenStations(String stationFrom, String stationTo) {

        Station sourceStation = stationService.findStationByName(stationFrom);
        Station targetStation = stationService.findStationByName(stationTo);

        return countDistanceWithCoordinates(sourceStation, targetStation);
    }

    private long countDistanceWithCoordinates(Station from, Station to) {
        long earthRad = 6372795;
        double lat1 = from.getLatitude()* Math.PI / 180;
        double lat2 = to.getLatitude()*Math.PI / 180;
        double long1 =from.getLongitude()*Math.PI / 180;
        double long2 = to.getLongitude()*Math.PI / 180;

        double cl1 = Math.cos(lat1);
        double cl2 = Math.cos(lat2);
        double sl1 = Math.sin(lat1);
        double sl2 = Math.sin(lat2);

        double delta = long2 - long1;
        double cdelta = Math.cos(delta);
        double sdelta = Math.sin(delta);

        double y = Math.sqrt(Math.pow(cl2 * sdelta, 2) + Math.pow(cl1 * sl2 - sl1 * cl2 * cdelta, 2));
        double x = sl1 * sl2 + cl1 * cl2 * cdelta;
        double ad = Math.atan2(y, x);
        long dist = (long) ad * earthRad;
        return dist;

    }

}
