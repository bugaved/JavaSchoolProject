package com.javaschool.dao;

import com.javaschool.entity.Route;
import com.javaschool.entity.Station;
import com.javaschool.entity.Waypoint;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class WayPointDao extends AbstractDao<Waypoint> {

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void create(Waypoint entity) {
        em.persist(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Waypoint> getAll() {
        TypedQuery<Waypoint> waypointTypedQuery = em.createQuery("SELECT w FROM Waypoint w", Waypoint.class);
        return waypointTypedQuery.getResultList();
    }

    /**
     * Returns waypoint with requred route and station
     *
     * @param route   - required route of waypoint
     * @param station - required station of waypoint
     * @return object of type Waypoint
     */
    @Transactional
    public Waypoint findWaypointByRouteAndStation(Route route, Station station) {
        TypedQuery<Waypoint> waypointTypedQuery = em.createQuery("SELECT w FROM Waypoint w WHERE w.route =?1 AND w.station =?2", Waypoint.class);
        waypointTypedQuery.setParameter(1, route);
        waypointTypedQuery.setParameter(2, station);
        return waypointTypedQuery.getSingleResult();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Waypoint waypoint) {
        em.remove(waypoint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAllEntites() {
        TypedQuery<Waypoint> waypointTypedQuery = em.createQuery("DELETE FROM Waypoint w", Waypoint.class);

    }

    @Transactional
    public void update(Waypoint waypoint) {
        em.merge(waypoint);
    }
}