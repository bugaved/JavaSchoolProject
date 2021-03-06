package com.javaschool.dao;

import com.javaschool.dto.StationScheduleDTO;
import com.javaschool.entity.Station;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class StationDao extends AbstractDao<Station> {

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Station station) {
        em.persist(station);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Station> getAll() {
        TypedQuery<Station> ticketTypedQuery = em.createQuery("SELECT stat FROM Station stat", Station.class);
        return ticketTypedQuery.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Station station) {
        Station searchingStation = findStationByName(station.getStationName());
        em.remove(searchingStation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAllEntities() {
        TypedQuery<Station> ticketTypedQuery = em.createQuery("DELETE FROM User u", Station.class);
        ticketTypedQuery.executeUpdate();
    }

    /**
     * Returns schedule of trains arriving on station and departuring from station.
     *
     * @param stationName  - the station where we watch the schedule
     * @param scheduleDate - the date where we watch schedule
     * @return List of objects of type StationScheduleDTO
     */
    public List<StationScheduleDTO> getStationSchedule(String stationName, DateTime scheduleDate) {

        DateTime startOfDay = scheduleDate
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0);

        DateTime endOfDay = scheduleDate
                .withHourOfDay(23)
                .withMinuteOfHour(59)
                .withSecondOfMinute(59);


        Query query = em.createNativeQuery("SELECT w.Id AS waypoint_id,station_name,arrival_time, departure_time, r.code,s_name_first,s_name_last FROM waypoints w\n" +
                "   JOIN stations s ON w.station_id = s.Id\n" +
                "   JOIN routes r ON w.route_id = r.id\n" +
                "   JOIN routes_grouped_by_first_and_last AS routes_view ON routes_view.code = r.code\n" +
                "   WHERE s.station_name = ?1\n" +
                "AND w.arrival_time > ?2\n" +
                "AND w.arrival_time < ?3", "stationScheduleResult");

        query.setParameter(1, stationName);
        query.setParameter(2, startOfDay.toDate());
        query.setParameter(3, endOfDay.toDate());

        return query.getResultList();
    }

    /**
     * Returns station with required name.
     *
     * @param stationName - the station name
     * @return object of type Station
     */
    public Station findStationByName(String stationName) {
        TypedQuery<Station> ticketTypedQuery = em.createQuery("SELECT stat FROM Station stat WHERE stat.stationName=?1", Station.class);
        ticketTypedQuery.setParameter(1, stationName);
        return ticketTypedQuery.getSingleResult();
    }
}
