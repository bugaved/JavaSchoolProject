package com.javaschool.services;

import com.javaschool.dao.TrainDao;
import com.javaschool.dto.TrainsStationsDTO;
import com.javaschool.entity.Route;
import com.javaschool.entity.Train;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;


@Service
public class TrainService {

    @Autowired
    private TrainDao trainDao;


    public void createTrain(Train train) {
        trainDao.create(train);
    }

    /**
     * Finds train thats go between requred stations in requred date.
     *
     * @param stationFrom - station from which train goes
     * @param stationTo   - station to which train goes
     * @param travelDate  - the date of the travel. (Day when train departures)
     * @return List of objects of type TrainStationsDTO
     */
    public List<TrainsStationsDTO> getTrainsByStationsAndDate(String stationFrom, String stationTo, DateTime travelDate) {
        return trainDao.getTrainsByStationsAndDate(stationFrom, stationTo, travelDate);
    }

    public Train findTrainByRoute(Route route) {

        Train train = null;

        try {
            train = trainDao.findTrainByRoute(route);
        } catch (NoResultException e) {
            System.out.println("No such Train found");
        }

        return train;
    }

    public void updateTrain(Train train) {
        trainDao.update(train);
    }

    public List<Train> getAllTrains() {
        return trainDao.getAll();
    }
}
