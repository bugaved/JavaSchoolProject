package com.javaschool.dao;

import com.javaschool.entity.Route;
import com.javaschool.utl.SqlLoader;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * Created by bugav on 04.10.2017.
 */
public class RouteDao extends AbstractDao<Route> implements SqlLoader {
    public List<Route> findRouteByDateAndStations(String stationA, String stationB, Date date) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            String sql = load("quires/1.sql");
            List trains = em.createNativeQuery(sql, Route.class)
                    .setParameter("A", stationA)
                    .setParameter("B", stationB)
                    .setParameter("date", date)
                    .getResultList();
            transaction.commit();
            return trains;
        } catch (Exception e) {
            transaction.rollback();
            return emptyList();
        }
    }
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
