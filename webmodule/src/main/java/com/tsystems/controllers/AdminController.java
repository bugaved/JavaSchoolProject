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
 * Controller that rules admin menu
 */
@Controller
public class AdminController {

    private static final Logger logger = Logger.getLogger(AdminController.class);

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

    private static final String ACTUAL_STATIONS = "actualStations";
    private static final String ACTUAL_TRAINS = "actualTrains";
    private static final String ACTUAL_WAYPOINTS = "actualWaypoints";
    private static final String ADMIN_JSP = "adminPage.jsp";
    private static final String LINE = "------------------------------------------------";


    /**
     * Creates station in database
     *
     * @param stationName - name of station
     * @param latitude    - latitude of station
     * @param longitude   - longitude of station
     * @return name of adminPage.jsp
     */
    @RequestMapping(value = "/createStation", method = RequestMethod.POST)
    public String createStation(@RequestParam("stationName") String stationName,
                                @RequestParam("latitude") String latitude,
                                @RequestParam("longitude") String longitude,
                                Model model) {

        logParamsCreateStation(stationName, latitude, longitude);

        Station station = new Station(stationName, Double.parseDouble(latitude), Double.parseDouble(longitude));
        stationService.createStation(station);

        List<Station> actualStations = stationService.getAllStations();
        List<Train> actualTrains = trainService.getAllTrains();
        List<Waypoint> actualWaypoints = waypointService.getAllWaypoints();

        model.addAttribute(ACTUAL_STATIONS, actualStations);
        model.addAttribute(ACTUAL_TRAINS, actualTrains);
        model.addAttribute(ACTUAL_WAYPOINTS, actualWaypoints);

        return ADMIN_JSP;
    }

    /**
     * Creates train in database
     *
     * @param trainName   - name of train
     * @param trainNumber - route code of train
     * @param seatsCount  - seats of train
     * @return name of adminPage.jsp
     */
    @RequestMapping(value = "/createTrain", method = RequestMethod.POST)
    public String createTrain(@RequestParam("trainName") String trainName,
                              @RequestParam("trainNumber") String trainNumber,
                              @RequestParam("seatsCount") String seatsCount,
                              Model model) {
        logParamsCreateTrain(trainName, trainNumber, seatsCount);
        Route route = routeService.findRouteByCode(trainNumber);

        if (route != null) {
            Train train = new Train(trainName, Integer.parseInt(seatsCount), route);
            trainService.createTrain(train);

            List<Station> actualStations = stationService.getAllStations();
            model.addAttribute(ACTUAL_STATIONS, actualStations);

            List<Train> actualTrains = trainService.getAllTrains();
            model.addAttribute(ACTUAL_TRAINS, actualTrains);

            return ADMIN_JSP;
        }

        routeService.createRoute(new Route(trainNumber));
        route = routeService.findRouteByCode(trainNumber);
        Train train = new Train(trainName, Integer.parseInt(seatsCount), route);
        trainService.createTrain(train);

        List<Station> actualStations = stationService.getAllStations();
        model.addAttribute(ACTUAL_STATIONS, actualStations);

        List<Train> actualTrains = trainService.getAllTrains();
        model.addAttribute(ACTUAL_TRAINS, actualTrains);

        List<Waypoint> actualWaypoints = waypointService.getAllWaypoints();
        model.addAttribute(ACTUAL_WAYPOINTS, actualWaypoints);

        return ADMIN_JSP;
    }

    /**
     * Creates waypoint in database
     *
     * @param stationName   - name of station in waypoint
     * @param routeCode     - route code of waypoint
     * @param arrivalTime   - arrival time of waypoint
     * @param departureTime - departure time of waypoint
     * @return name of adminPage.jsp
     */
    @RequestMapping(value = "/createWayPoint", method = RequestMethod.POST)
    public String createWayPoint(@RequestParam("stationName") String stationName,
                                 @RequestParam("routeCode") String routeCode,
                                 @RequestParam("arrivalTime") String arrivalTime,
                                 @RequestParam("departureTime") String departureTime,
                                 Model model) {

        logParamsCreateWayPoint(stationName, routeCode, arrivalTime, departureTime);

        Route route = routeService.findRouteByCode(routeCode);
        Station station = stationService.findStationByName(stationName);

        String convertedArrivalTime = stringFormatter.deleteSymbolFromString(arrivalTime, 'T');
        String convertedDepartureTime = stringFormatter.deleteSymbolFromString(departureTime, 'T');

        Date arrivalDateTime = converter.convertStringToDate(convertedArrivalTime, DateTimePatterns.DATE_AMERICA_WITH_TIME.getValue());
        Date departureDateTime = converter.convertStringToDate(convertedDepartureTime, DateTimePatterns.DATE_AMERICA_WITH_TIME.getValue());

        if (route != null && station != null) {

            Waypoint waypoint = waypointService.findWaypointByRouteAndStation(route, station);

            if (waypoint == null) {
                Waypoint newWaypoint = new Waypoint(arrivalDateTime, departureDateTime, station, route);
                waypointService.persistWaypoint(newWaypoint);
            } else {
                waypoint.setDepartureTime(departureDateTime);
                waypoint.setArrivalTime(arrivalDateTime);

                waypointService.updateWaypoint(waypoint);
            }

        }

        List<Station> actualStations = stationService.getAllStations();
        List<Train> actualTrains = trainService.getAllTrains();
        List<Waypoint> actualWaypoints = waypointService.getAllWaypoints();

        model.addAttribute(ACTUAL_STATIONS, actualStations);
        model.addAttribute(ACTUAL_TRAINS, actualTrains);
        model.addAttribute(ACTUAL_WAYPOINTS, actualWaypoints);

        return ADMIN_JSP;
    }

    /**
     * finds passangers, who have ticket with required route code
     *
     * @param routeCode - routeCode of passangers ticket
     * @return name of adminPage.jsp
     */
    @RequestMapping(value = "/findPassengersByRoute", method = RequestMethod.POST)
    public String findPassengersByRoute(@RequestParam("routeCodeForPassengers") String routeCode, Model model) {

        logParamsFindPassengersByRoute(routeCode);

        Route route = routeService.findRouteByCode(routeCode);
        List<User> users = new ArrayList<>();

        if (route != null) {
            route.getTickets().forEach(ticket -> users.add(ticket.getUser()));
        }

        model.addAttribute("users", users);

        List<Station> actualStations = stationService.getAllStations();
        List<Train> actualTrains = trainService.getAllTrains();
        List<Waypoint> actualWaypoints = waypointService.getAllWaypoints();

        model.addAttribute(ACTUAL_STATIONS, actualStations);
        model.addAttribute(ACTUAL_TRAINS, actualTrains);
        model.addAttribute(ACTUAL_WAYPOINTS, actualWaypoints);

        return ADMIN_JSP;

    }

    /**
     * finds all routes in database
     *
     * @return name of adminPage.jsp
     */
    @RequestMapping(value = "/viewRoutes", method = RequestMethod.GET)
    public String findRoutes(Model model) {

        List<RoutesDTO> routes = routeService.findAllRoutes();
        model.addAttribute("routes", routes);

        return ADMIN_JSP;

    }

    private void logParamsCreateStation(String stationName, String latitude, String longitude) {

        logger.info(LINE);
        logger.info("|AdminController class|, |createStation method|, |station name param| is:" + stationName);
        logger.info("|AdminController class|, |createStation method|, |statioon latitude param| is:" + latitude);
        logger.info("|AdminController class|, |createStation method|, |station longitude param| is:" + longitude);
        logger.info(LINE);

    }

    private void logParamsCreateTrain(String trainName, String trainNumber, String seatsCount) {

        logger.info(LINE);
        logger.info("|AdminController class|, |createTrain method|, |Train name param| is:" + trainName);
        logger.info("|AdminController class|, |createTrain method|, |Train number param| is:" + trainNumber);
        logger.info("|AdminController class|, |createTrain method|, |Train seats count param| is:" + seatsCount);
        logger.info(LINE);

    }

    private void logParamsCreateWayPoint(String stationName, String routeCode, String arrivalTime, String departureTime) {

        logger.info(LINE);
        logger.info("|AdminController class|, |createWayPoint method|, |waypoint station name param| is:" + stationName);
        logger.info("|AdminController class|, |createWayPoint method|, |Waypoint route code| is:" + routeCode);
        logger.info("|AdminController class|, |createWayPoint method|, |waypoint arrival time| is:" + arrivalTime);
        logger.info("|AdminController class|, |createWayPoint method|, |waypoint departure time| is:" + departureTime);
        logger.info(LINE);

    }

    private void logParamsFindPassengersByRoute(String routeCode) {

        logger.info(LINE);
        logger.info("|AdminController class|, |findPassengersByRoute method|, |routeCode for passengers| is:" + routeCode);
        logger.info(LINE);

    }


}
