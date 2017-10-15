package com.javaschool.dao;

import com.javaschool.dto.TrainsStationsDTO;
import com.javaschool.entity.Route;
import com.javaschool.entity.Train;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import java.util.List;

@Component
public class TrainDao extends AbstractDao<Train> {
    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Train entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Train> getAll() {
        em.getTransaction().begin();
        TypedQuery<Train> userTypedQuery = em.createQuery("SELECT t FROM Train t", Train.class);
        List<Train> trains = userTypedQuery.getResultList();
        em.getTransaction().commit();

        return trains;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Train train) {
        em.getTransaction().begin();
        em.remove(train);
        em.getTransaction().commit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAllEntites() {
        TypedQuery<Train> userTypedQuery = em.createQuery("DELETE FROM Train t", Train.class);
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

        DateTime startOfDay = travelDate
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0);

        DateTime endOfDay = travelDate
                .withHourOfDay(23)
                .withMinuteOfHour(59)
                .withSecondOfMinute(59);

        Query query = em.createNativeQuery("SELECT DISTINCT v1.code,v1.station_name AS station_from,v2.station_name AS station_to,v1.departure_time,v2.arrival_time,v1.seats_count FROM(SELECT * FROM trains_stations_view v\n" +
                "WHERE ?1 < v.departure_time AND v.departure_time < ?2 AND v.station_name = ?3) AS v1\n" +
                "JOIN (SELECT * FROM trains_stations_view v WHERE v.station_name = ?4 ) AS v2 ON v1.code = v2.code", "trainStationsResult");

        query.setParameter(1, startOfDay.toDate());
        query.setParameter(2, endOfDay.toDate());
        query.setParameter(3, stationFrom);
        query.setParameter(4, stationTo);

        return query.getResultList();
    }

    public List<Train> findTrainByRoute(Route route) {
        TypedQuery<Train> trainTypedQuery = em.createQuery("SELECT tr FROM Train tr WHERE tr.route =?1", Train.class);
        trainTypedQuery.setParameter(1, route);
        List<Train> trains = trainTypedQuery.getResultList();
        return trains;
    }
}
