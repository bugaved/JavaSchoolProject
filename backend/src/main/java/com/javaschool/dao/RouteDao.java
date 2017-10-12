package com.javaschool.dao;

import com.javaschool.entity.Route;
import org.springframework.stereotype.Component;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

import static java.util.Collections.emptyList;

@Component
public class RouteDao extends AbstractDao<Route>  {

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
