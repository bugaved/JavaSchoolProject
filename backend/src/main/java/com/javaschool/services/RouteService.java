package com.javaschool.services;

import com.javaschool.dao.RouteDao;
import com.javaschool.dto.RoutesDTO;
import com.javaschool.entity.Route;
import com.javaschool.jms.NotifyProducer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.persistence.NoResultException;
import java.util.List;


@Service
public class RouteService {

    private static final Logger logger = Logger.getLogger(RouteService.class);

    @Autowired
    private RouteDao routeDao;

    @Autowired
    private NotifyProducer notifyProducer;

    /**
     * Returns route with required route code.
     *
     * @param routeCode - the required route code
     * @return object of type Route
     */
    public Route findRouteByCode(String routeCode) {

        Route route = null;

        try {
            route = routeDao.findRouteByCode(routeCode);
        } catch (NoResultException e) {
            logger.info("|RouteService class|, |findRouteByCode method| NoResultException");
        }
        return route;
    }
    /**
     * {@inheritDoc}
     */
    public void createRoute(Route route) {
        try {
            routeDao.create(route);
            notifyProducer.sendNotifyUpdate();
        } catch (JMSException e) {
            logger.info("|RouteService class|, |findRouteByCode method| JMS Exception");
        }
    }
    /**
     * {@inheritDoc}
     */
    public void deleteRoute(Route route) {
        routeDao.delete(route);
    }
    /**
     * Returns all routes in database.
     *
     * @return List if object of type RouteDTO
     */

    public void updateRoute(Route route){
        routeDao.updateRoute(route);
    }

    public List<RoutesDTO> findAllRoutes() {
        return routeDao.findAllRoutes();
    }
}
