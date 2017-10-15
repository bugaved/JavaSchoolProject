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

    /**
     * Returns schedule of trains arriving from station.
     * @return List of objects of type StationScheduleDTO
     * @param stationName  - the station where we watch the schedule
     * @param  scheduleDate - the date where we watch schedule
     */
    public List<StationScheduleDTO> getStationArrivalSchedule(String stationName, DateTime scheduleDate) {
        return stationDao.getStationArrivalSchedule(stationName, scheduleDate);
    }
    /**
     * Returns schedule of trains departuring from station.
     * @return List of objects of type StationScheduleDTO
     * @param stationName  - the station where we watch the schedule
     * @param scheduleDate - the date where we watch schedule
     */
    public List<StationScheduleDTO> getStationDepartureSchedule(String stationName, DateTime scheduleDate) {
        return stationDao.getStationDepartureSchedule(stationName, scheduleDate);
    }
}
