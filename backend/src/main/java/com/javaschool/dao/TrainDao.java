package com.javaschool.dao;

import com.javaschool.dto.TrainsStationsDTO;
import com.javaschool.entity.Route;
import com.javaschool.entity.Train;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class TrainDao extends AbstractDao<Train> {
    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Train entity) {
        em.persist(entity);
    }

    /**
     * {@inheritDoc}
     */
    public void update(Train train) {
        em.merge(train);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Train> getAll() {
        TypedQuery<Train> userTypedQuery = em.createQuery("SELECT t FROM Train t", Train.class);
        return userTypedQuery.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Train train) {
        Train searchingTrain = findTrainByRoute(train.getRoute());
        em.remove(searchingTrain);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAllEntites() {
        em.createQuery("DELETE FROM Train t", Train.class);
    }

    /**
     * Finds train thats runs between requred stations in requred date.
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

    /**
     * Finds train with required route.
     *
     * @param route - required route
     * @return object of type Train
     */
    public Train findTrainByRoute(Route route) {
        TypedQuery<Train> trainTypedQuery = em.createQuery("SELECT tr FROM Train tr WHERE tr.route =?1", Train.class);
        trainTypedQuery.setParameter(1, route);
        return trainTypedQuery.getSingleResult();
    }
}
