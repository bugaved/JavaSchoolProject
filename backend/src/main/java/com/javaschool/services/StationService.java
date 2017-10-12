package com.javaschool.services;

import com.javaschool.dao.StationDao;
import com.javaschool.dto.WaypointsStationsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StationService {
    @Autowired
    private StationDao stationDao;

    public List<WaypointsStationsDTO> getStationsSchedule(String stationName)
    {
       return stationDao.getStationSchedule(stationName);
    }
}
