package com.javaschool.services;

import com.javaschool.dao.TrainDao;
import com.javaschool.dto.TrainsStationsDTO;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bugav on 08.10.2017.
 */
@Service
public class TrainService {

    @Autowired
    private TrainDao trainDao;


    public List<TrainsStationsDTO> getTrainsByStationsAndDate(String stationFrom, String stationTo, DateTime travelDate) {
        return trainDao.getTrainsByStationsAndDate(stationFrom, stationTo, travelDate);
    }

}
