package com.javaschool.services;

import com.javaschool.dao.StationDao;
import com.javaschool.dto.StationScheduleDTO;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationDao stationDao;

    public List<StationScheduleDTO> getStationArrivalSchedule(String stationName, DateTime travelDate) {
        return stationDao.getStationArrivalSchedule(stationName, travelDate);
    }

    public List<StationScheduleDTO> getStationDepartureSchedule(String stationName, DateTime travelDate) {
        return stationDao.getStationDepartureSchedule(stationName, travelDate);
    }
}
