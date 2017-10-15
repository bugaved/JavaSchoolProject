package com.javaschool.services;

import com.javaschool.dao.RouteDao;
import com.javaschool.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    @Autowired
    private RouteDao routeDao;

    public List<Route> findRouteByCode(String routeCode) {
        return routeDao.findRouteByCode(routeCode);
    }
}
