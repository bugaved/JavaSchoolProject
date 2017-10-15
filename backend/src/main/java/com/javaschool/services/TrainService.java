package com.javaschool.services;

import com.javaschool.dao.TrainDao;
import com.javaschool.dto.TrainsStationsDTO;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.requireNonNull;


@Service
public class TrainService {

    @Autowired
    private TrainDao trainDao;

    /**
     * Finds train thats go between requred stations in requred date.
     * @return List of objects of type TrainStationsDTO
     * @param  stationFrom - station from which train goes
     * @param  stationTo - station to which train goes
     * @param  travelDate - the date of the travel. (Day when train departures)
     */
    public List<TrainsStationsDTO> getTrainsByStationsAndDate(String stationFrom, String stationTo, DateTime travelDate) {
        return trainDao.getTrainsByStationsAndDate(stationFrom, stationTo, travelDate);
    }

}
