package com.javaschool.dao;

import com.javaschool.dto.RoutesDTO;
import com.javaschool.entity.Route;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@Component
public class RouteDao extends AbstractDao<Route> {

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Route entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Route> getAll() {
        TypedQuery<Route> ticketTypedQuery = em.createQuery("SELECT route FROM Route route", Route.class);
        List<Route> routes = ticketTypedQuery.getResultList();
        return routes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Route route) {
        em.getTransaction().begin();
        em.remove(route);
        em.getTransaction().commit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAllEntites() {
        TypedQuery<Route> ticketTypedQuery = em.createQuery("DELETE FROM Route r", Route.class);
        ticketTypedQuery.executeUpdate();
    }

    /**
     * Returns route with required route code.
     *
     * @param routeCode - the required route code
     * @return object of type Route
     */
    public Route findRouteByCode(String routeCode) {
        TypedQuery<Route> routeTypedQuery = em.createQuery("SELECT r FROM Route r WHERE r.code=?1", Route.class);
        routeTypedQuery.setParameter(1, routeCode);
        return routeTypedQuery.getSingleResult();
    }

    /**
     * Returns all routes in database.
     *
     * @return List if object of type RouteDTO
     */
    public List<RoutesDTO> findAllRoutes() {

        Query routeQuery = em.createNativeQuery("SELECT * FROM routes_grouped_by_first_and_last", "routesResult");

        return routeQuery.getResultList();
    }

}
