package com.tsystems.controllers;

import com.javaschool.dto.RoutesDTO;
import com.javaschool.entity.*;
import com.javaschool.services.RouteService;
import com.javaschool.services.StationService;
import com.javaschool.services.TrainService;
import com.javaschool.services.WaypointService;
import com.tsystems.utils.DateTimeComponent;
import com.tsystems.utils.DateTimePatterns;
import com.tsystems.utils.StringFormatter;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by bugav on 19.10.2017.
 */
@Controller
public class AdminController {

    @Autowired
    private DateTimeComponent converter;

    @Autowired
    private StationService stationService;

    @Autowired
    private WaypointService waypointService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private StringFormatter stringFormatter;


    @RequestMapping(value = "/createStation", method = RequestMethod.POST)
    public String createStation(@RequestParam("stationName") String stationName,
                                @RequestParam("lattitude") String lattitude,
                                @RequestParam("longitude") String longitude) {

        Station station = new Station(stationName, Double.parseDouble(lattitude), Double.parseDouble(longitude));
        stationService.createStation(station);

        return "adminPage";
    }

    @RequestMapping(value = "/createTrain", method = RequestMethod.POST)
    public String createTrain(@RequestParam("trainName") String trainName,
                              @RequestParam("trainNumber") String trainNumber,
                              @RequestParam("seatsCount") String seatsCount) {

        Route route = routeService.findRouteByCode(trainNumber);

        if (route != null) {
            Train train = new Train(trainName, Integer.parseInt(seatsCount), route);
            trainService.createTrain(train);
            return "adminPage";
        }

        routeService.createRoute(new Route(trainNumber));
        route = routeService.findRouteByCode(trainNumber);
        Train train = new Train(trainName, Integer.parseInt(seatsCount), route);
        trainService.createTrain(train);

        return "adminPage";
    }


    @RequestMapping(value = "createWayPoint", method = RequestMethod.POST)
    public String createWayPoint(@RequestParam("stationName") String stationName,
                                 @RequestParam("routeCode") String routeCode,
                                 @RequestParam("arrivalTime") String arrivalTime,
                                 @RequestParam("departureTime") String departureTime) {

        Route route = routeService.findRouteByCode(routeCode);
        Station station = stationService.findStationByName(stationName);

        String convertedArrivalTime = stringFormatter.deleteSymbolFromString(arrivalTime,'T');
        String convertedDepartureTime = stringFormatter.deleteSymbolFromString(departureTime,'T');

        Date arrivalDateTime = converter.convertStringToDate(convertedArrivalTime, DateTimePatterns.DATE_AMERICA_WITH_TIME.getValue());
        Date departureDateTime = converter.convertStringToDate(convertedDepartureTime, DateTimePatterns.DATE_AMERICA_WITH_TIME.getValue());

        if (route != null && station != null) {
            Waypoint waypoint = new Waypoint(arrivalDateTime, departureDateTime, station, route);
            waypointService.persistWaypoint(waypoint);
        }

        return "adminPage";
    }


    @RequestMapping(value = "/findPassengersByRoute", method = RequestMethod.POST)
    public String findPassengersByRoute(@RequestParam("routeCodeForPassengers") String routeCode, Model model) {


        Route route = routeService.findRouteByCode(routeCode);

        List<User> users = new ArrayList<>();

        if (route != null) {
            route.getTickets().forEach(ticket -> users.add(ticket.getUser()));
        }

        model.addAttribute("users", users);

        return "adminPage";


    }


    @RequestMapping(value = "/viewRoutes", method = RequestMethod.GET)
    public String findPassengersByRoute(Model model) {

        List<RoutesDTO> routes = routeService.findAllRoutes();
        model.addAttribute("routes", routes);

        return "adminPage";

    }


}
