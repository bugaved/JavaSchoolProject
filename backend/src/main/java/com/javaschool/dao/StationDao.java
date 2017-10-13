package com.javaschool.dao;

import com.javaschool.dto.WaypointsStationsDTO;
import com.javaschool.entity.Station;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Component
public class StationDao extends AbstractDao<Station> {
    @Override
    public void create(Station entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<Station> getAll() {
        TypedQuery<Station> ticketTypedQuery = em.createQuery("SELECT stat FROM Station stat", Station.class);
        List<Station> stations = ticketTypedQuery.getResultList();
        return stations;
    }

    @Override
    public void delete(Station station) {
        em.getTransaction().begin();
        em.remove(station);
        em.getTransaction().commit();
    }


    @Override
    public void deleteAllEntites() {
        TypedQuery<Station> ticketTypedQuery = em.createQuery("DELETE FROM User u", Station.class);
        ticketTypedQuery.executeUpdate();
    }

    public List<WaypointsStationsDTO> getStationSchedule(String stationName, DateTime travelDate) {
        DateTime startOfDay = travelDate
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0);

        DateTime endOfDay = travelDate
                .withHourOfDay(23)
                .withMinuteOfHour(59)
                .withSecondOfMinute(59);


        Query query = em.createNativeQuery("SELECT  arrival_time, departure_time, station_name, name, seats_count, code\n" +
                "   FROM waypoints \n" +
                "   INNER JOIN stations\n" +
                "   ON waypoints.station_id = STATIONS.id\n" +
                "   INNER JOIN trains\n" +
                "   ON waypoints.route_id = trains.route_id\n" +
                "   INNER JOIN routes\n" +
                "   ON waypoints.route_id = routes.id\n" +
                "   WHERE station_name = ?1 AND waypoints.departure_time < ?2 AND waypoints.departure_time > ?3", "waypointStationsResult");

        query.setParameter(1, stationName);
        query.setParameter(2, endOfDay);
        query.setParameter(3, startOfDay);
        return query.getResultList();
    }

}
