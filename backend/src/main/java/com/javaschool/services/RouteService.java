package com.javaschool.services;

import com.javaschool.dao.RouteDao;
import com.javaschool.dto.RoutesDTO;
import com.javaschool.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;


@Service
public class RouteService {

    @Autowired
    private RouteDao routeDao;


    public Route findRouteByCode(String routeCode) {

        Route route = null;

        try {
            route = routeDao.findRouteByCode(routeCode);
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return route;
    }

    public void createRoute(Route route) {
        routeDao.create(route);
    }

    public List<RoutesDTO> findAllRoutes() {
        return routeDao.findAllRoutes();
    }
}
