package com.tsystems.controllers;

import com.javaschool.entity.Route;
import com.javaschool.entity.Station;
import com.javaschool.entity.Train;
import com.javaschool.services.RouteService;
import com.javaschool.services.StationService;
import com.javaschool.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by bugav on 19.10.2017.
 */
@Controller
public class AdminController {

    @Autowired
    private StationService stationService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private TrainService trainService;


    @RequestMapping("/createStation")
    public String createStation(@RequestParam("stationName") String stationName,
                                @RequestParam("lattitude") String lattitude,
                                @RequestParam("longitude") String longitude) {

        Station station = new Station(stationName, Double.parseDouble(lattitude), Double.parseDouble(longitude));

        stationService.createStation(station);

        return "adminPage";
    }

    @RequestMapping("/createTrain")
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

}
