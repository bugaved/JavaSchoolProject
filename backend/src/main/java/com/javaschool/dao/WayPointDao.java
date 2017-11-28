package com.javaschool.dao;

import com.javaschool.entity.Route;
import com.javaschool.entity.Station;
import com.javaschool.entity.Waypoint;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;
@Component
public class WayPointDao extends AbstractDao<Waypoint> {

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Waypoint entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Waypoint> getAll() {
        em.getTransaction().begin();
        TypedQuery<Waypoint> waypointTypedQuery = em.createQuery("SELECT w FROM Waypoint w", Waypoint.class);
        List<Waypoint> users = waypointTypedQuery.getResultList();
        em.getTransaction().commit();

        return users;
    }
    /**
     * Returns waypoint with requred route and station
     *
     * @param route        - required route of waypoint
     * @param station    - required station of waypoint
     * @return object of type Waypoint
     */
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
    public void delete(Waypoint user) {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAllEntites() {
        TypedQuery<Waypoint> waypointTypedQuery = em.createQuery("DELETE FROM Waypoint w", Waypoint.class);

    }
}