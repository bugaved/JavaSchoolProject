package com.javaschool.services;

import com.javaschool.dao.RouteDao;
import com.javaschool.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bugav on 15.10.2017.
 */
public class RouteService {
    @Autowired
    private RouteDao routeDao;

    public List<Route> findRouteByCode(String routeCode) {
        return routeDao.findRouteByCode(routeCode);
    }
}
