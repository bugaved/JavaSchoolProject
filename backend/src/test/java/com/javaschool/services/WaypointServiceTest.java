package com.javaschool.services;

import com.javaschool.entity.Route;
import com.javaschool.entity.Station;
import com.javaschool.entity.Waypoint;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context.xml")
public class WaypointServiceTest {

    @Autowired
    private WaypointService waypointService;
    @Autowired
    private StationService stationService;
    @Autowired
    private RouteService routeService;

    @Test
    public void findAllWaypointsTest() {
        List<Waypoint> waypoints = waypointService.getAllWaypoints();
        assertNotNull(waypoints);
    }

    @Test
    public void createWaypointTest() throws ParseException {

        String arrivalStringDate = "2017-09-04 19:30";
        String departureStringDate = "2017-09-04 20:30";

        Date arrivalDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(arrivalStringDate);
        Date departureDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(departureStringDate);

        Station station = stationService.findStationByName("Moscow");
        Route route = routeService.findRouteByCode("MM1");

        Waypoint waypoint = new Waypoint(arrivalDate, departureDate, station, route);
        waypointService.persistWaypoint(waypoint);

        Waypoint testWaypoint = waypointService.findWaypointByRouteAndStation(route, station);
        assertEquals("MM1", testWaypoint.getRoute().getCode());

    }

    @After
    public void cleanRoute() throws ParseException {
        Station station = stationService.findStationByName("Moscow");
        Route route = routeService.findRouteByCode("MM1");
        Waypoint waypoint = waypointService.findWaypointByRouteAndStation(route, station);

        if (waypoint != null) {
            waypointService.deleteWaypoint(waypoint);
        }
    }


}
