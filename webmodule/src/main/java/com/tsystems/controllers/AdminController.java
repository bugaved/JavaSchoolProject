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
import org.apache.log4j.Logger;
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
    private final static Logger logger = Logger.getLogger(AdminController.class);

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
                                @RequestParam("latitude") String latitude,
                                @RequestParam("longitude") String longitude,
                                Model model) {
        logger.info("stationName from createStation page is:" + stationName);
        logger.info("latitude from createStation page is:" + latitude);
        logger.info("longitude from createStation page is:" + longitude);

        Station station = new Station(stationName, Double.parseDouble(latitude), Double.parseDouble(longitude));
        stationService.createStation(station);

        List<Station> actualStations = stationService.getAllStations();
        model.addAttribute("actualStations", actualStations);

        return "adminPage";
    }

    @RequestMapping(value = "/createTrain", method = RequestMethod.POST)
    public String createTrain(@RequestParam("trainName") String trainName,
                              @RequestParam("trainNumber") String trainNumber,
                              @RequestParam("seatsCount") String seatsCount,
                              Model model) {
        logger.info("trainName from createTrain page is:" + trainName);
        logger.info("Route code from createTrain page is:" + trainNumber);
        logger.info("seats count from createTrain page is:" + seatsCount);

        Route route = routeService.findRouteByCode(trainNumber);

        if (route != null) {
            Train train = new Train(trainName, Integer.parseInt(seatsCount), route);
            trainService.createTrain(train);

            List<Station> actualStations = stationService.getAllStations();
            model.addAttribute("actualStations", actualStations);

            List<Train> actualTrains = trainService.getAllTrains();
            model.addAttribute("actualTrains", actualTrains);

            return "adminPage.jsp";
        }

        routeService.createRoute(new Route(trainNumber));
        route = routeService.findRouteByCode(trainNumber);
        Train train = new Train(trainName, Integer.parseInt(seatsCount), route);
        trainService.createTrain(train);

        List<Station> actualStations = stationService.getAllStations();
        model.addAttribute("actualStations", actualStations);

        List<Train> actualTrains = trainService.getAllTrains();
        model.addAttribute("actualTrains", actualTrains);

        List<Waypoint> actualWaypoints = waypointService.getAllWaypoints();
        model.addAttribute("actualWaypoints", actualWaypoints);

        return "adminPage.jsp";
    }


    @RequestMapping(value = "createWayPoint", method = RequestMethod.POST)
    public String createWayPoint(@RequestParam("stationName") String stationName,
                                 @RequestParam("routeCode") String routeCode,
                                 @RequestParam("arrivalTime") String arrivalTime,
                                 @RequestParam("departureTime") String departureTime) {

        logger.info("StationName from createWaypoint page is:" + stationName);
        logger.info("routeCode from createWaypoint page is:" + routeCode);
        logger.info("arrival time from createWaypoint page is:" + arrivalTime);
        logger.info("departure time from createWaypoint page is:" + departureTime);

        Route route = routeService.findRouteByCode(routeCode);
        Station station = stationService.findStationByName(stationName);

        String convertedArrivalTime = stringFormatter.deleteSymbolFromString(arrivalTime, 'T');
        String convertedDepartureTime = stringFormatter.deleteSymbolFromString(departureTime, 'T');

        Date arrivalDateTime = converter.convertStringToDate(convertedArrivalTime, DateTimePatterns.DATE_AMERICA_WITH_TIME.getValue());
        Date departureDateTime = converter.convertStringToDate(convertedDepartureTime, DateTimePatterns.DATE_AMERICA_WITH_TIME.getValue());

        if (route != null && station != null) {
            Waypoint waypoint = new Waypoint(arrivalDateTime, departureDateTime, station, route);
            waypointService.persistWaypoint(waypoint);
        }

        return "adminPage.jsp";
    }


    @RequestMapping(value = "/findPassengersByRoute", method = RequestMethod.POST)
    public String findPassengersByRoute(@RequestParam("routeCodeForPassengers") String routeCode, Model model) {

        logger.info("RouteCode from findPassengersByRoute page is:" + routeCode);

        Route route = routeService.findRouteByCode(routeCode);
        List<User> users = new ArrayList<>();

        if (route != null) {
            route.getTickets().forEach(ticket -> users.add(ticket.getUser()));
        }

        model.addAttribute("users", users);
        return "adminPage.jsp";

    }


    @RequestMapping(value = "/viewRoutes", method = RequestMethod.GET)
    public String findRoutes(Model model) {

        List<RoutesDTO> routes = routeService.findAllRoutes();
        model.addAttribute("routes", routes);

        return "adminPage.jsp";

    }


}
