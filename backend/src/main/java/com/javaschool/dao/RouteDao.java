package com.javaschool.dao;

import com.javaschool.entity.Route;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by bugav on 04.10.2017.
 */
public class RouteDao extends AbstractDao<Route> {
    @Override
    public void create(Route entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<Route> getAll() {
        TypedQuery<Route> ticketTypedQuery = em.createQuery("SELECT route FROM Route route", Route.class);
        List<Route> routs = ticketTypedQuery.getResultList();
        return routs;
    }

    @Override
    public void delete(Route route) {
        em.getTransaction().begin();
        em.remove(route);
        em.getTransaction().commit();
    }


    @Override
    public void deleteAllEntites() {
        TypedQuery<Route> ticketTypedQuery = em.createQuery("DELETE FROM Route r", Route.class);
        ticketTypedQuery.executeUpdate();
    }
}
