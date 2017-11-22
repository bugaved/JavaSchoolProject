package com.javaschool.services;

import com.javaschool.dao.StationDao;
import com.javaschool.dto.StationScheduleDTO;
import com.javaschool.entity.Station;
import com.javaschool.jms.NotifyProducer;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationDao stationDao;

    @Autowired
    private NotifyProducer notifyProducer;


    public void createStation(Station station) {
        try {
            stationDao.create(station);
            notifyProducer.sendNotifyUpdate();
        } catch (JMSException e) {
            System.out.println("------------|Can't send message to Broker");
        }
    }

    public List<Station> getAllStations() {
        return stationDao.getAll();
    }

    /**
     * Returns schedule of trains arriving from station.
     *
     * @param stationName  - the station where we watch the schedule
     * @param scheduleDate - the date where we watch schedule
     * @return List of objects of type StationScheduleDTO
     */
    public List<StationScheduleDTO> getStationArrivalSchedule(String stationName, DateTime scheduleDate) {
        return stationDao.getStationArrivalSchedule(stationName, scheduleDate);
    }

    /**
     * Returns schedule of trains departuring from station.
     *
     * @param stationName  - the station where we watch the schedule
     * @param scheduleDate - the date where we watch schedule
     * @return List of objects of type StationScheduleDTO
     */
    public List<StationScheduleDTO> getStationDepartureSchedule(String stationName, DateTime scheduleDate) {
        return stationDao.getStationDepartureSchedule(stationName, scheduleDate);
    }

    public Station findStationByName(String stationName) {
        return stationDao.findStationByName(stationName);
    }
}
