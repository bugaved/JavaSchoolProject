package com.javaschool.services;

import com.javaschool.dao.StationDao;
import com.javaschool.dto.WaypointsStationsDTO;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StationService {
    @Autowired
    private StationDao stationDao;

    public List<WaypointsStationsDTO> getStationsSchedule(String stationName, DateTime travelDate)
    {
       return stationDao.getStationSchedule(stationName, travelDate);
    }
}
