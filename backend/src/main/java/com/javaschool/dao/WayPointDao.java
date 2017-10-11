package com.javaschool.dao;

import com.javaschool.entity.Waypoint;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;


@Component
public class WaypointDao extends AbstractDao<Waypoint> {

    @Override
    public void create(Waypoint entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<Waypoint> getAll() {
        em.getTransaction().begin();
        TypedQuery<Waypoint> waypointTypedQuery = em.createQuery("SELECT w FROM Waypoint w", Waypoint.class);
        List<Waypoint> users = waypointTypedQuery.getResultList();
        em.getTransaction().commit();

        return users;
    }



    @Override
    public void delete(Waypoint user) {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }


    @Override
    public void deleteAllEntites() {
        TypedQuery<Waypoint> waypointTypedQuery = em.createQuery("DELETE FROM Waypoint w", Waypoint.class);

    }
}