package com.javaschool.services;

import com.javaschool.dto.RoutesDTO;
import com.javaschool.entity.Route;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


/**
 * Created by bugav on 25.11.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context.xml")
public class RouteServiceTest {

    @Autowired
    private RouteService routeService;


    @Test
    public void findExistingRouteTest() {
        Route route = routeService.findRouteByCode("T34");
        assertEquals("T34", route.getCode());
    }

    @Test
    public void findNonExistingRouteTest() {
        Route route = routeService.findRouteByCode("BFFGG");
        assertNull(route);
    }

    @Test
    public void createRouteTest() {

        Route route = new Route("Test");
        routeService.createRoute(route);

        Route testRoute = routeService.findRouteByCode("Test");
        assertEquals("Test", testRoute.getCode());

    }

    @Test
    public void findAllRoutesTest() {
        List<RoutesDTO> routes = routeService.findAllRoutes();
        assertNotNull(routes);
    }

    @After
    public void cleanRoute() {

        Route route = routeService.findRouteByCode("Test");

        if (route != null) {
            routeService.deleteRoute(route);
        }
    }

}
