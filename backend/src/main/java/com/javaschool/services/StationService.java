package com.javaschool.services;

import com.javaschool.dao.StationDao;
import com.javaschool.dto.StationScheduleDTO;
import com.javaschool.entity.Station;
import com.javaschool.jms.NotifyProducer;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.persistence.NoResultException;
import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationDao stationDao;

    @Autowired
    private NotifyProducer notifyProducer;

    /**
     * {@inheritDoc}
     */
    public void createStation(Station station) {
        try {
            stationDao.create(station);
            notifyProducer.sendNotifyUpdate();
        } catch (JMSException e) {
            System.out.println("------------|Can't send message to Broker");
        }
    }
    /**
     * Returns all stations in database.
     *
     * @return List if object of type Station
     */
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
    public List<StationScheduleDTO> getStationSchedule(String stationName, DateTime scheduleDate) {
        return stationDao.getStationSchedule(stationName, scheduleDate);
    }
    /**
     * Returns station with required name.
     *
     * @param stationName  - the station name
     * @return object of type Station
     */
    public Station findStationByName(String stationName) {

        Station station = null;

        try {
            station = stationDao.findStationByName(stationName);
        } catch (NoResultException e) {
            System.out.println("No such station");
        }
        return station;
    }
    /**
     * {@inheritDoc}
     */
    public void deleteStation(Station station) {
        stationDao.delete(station);
    }
}
