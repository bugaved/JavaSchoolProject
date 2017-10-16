package com.tsystems.controllers;

import com.javaschool.entity.Route;
import com.javaschool.entity.Ticket;
import com.javaschool.entity.Train;
import com.javaschool.entity.User;
import com.javaschool.services.RouteService;
import com.javaschool.services.TicketService;
import com.javaschool.services.TrainService;
import com.javaschool.services.UserService;
import com.tsystems.utils.DateTimeComponent;
import com.tsystems.utils.DateTimePatterns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;


@Controller
public class BuyTicketController {

    @Autowired
    private DateTimeComponent converter;

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private TrainService trainService;


    @RequestMapping(value = "/buyTicket", method = RequestMethod.POST)
    public String buyTicket(@RequestParam(value = "name") String name,
                            @RequestParam(value = "lastName") String lastName,
                            @RequestParam(value = "birthDate") String birthDate,
                            @RequestParam(value = "route") String route,
                            @RequestParam(value = "stationFrom") String stationFrom,
                            @RequestParam(value = "stationTo") String stationTo,
                            @RequestParam(value = "departureDate") String departureDate,
                            @RequestParam(value = "arrivalDate") String arrivalDate,
                            Model model) {

        Date userBirthDate = converter.convertStringToDate(birthDate, DateTimePatterns.COMMON_DATE_WITHOUT_TIME_AMERICAN.getValue());

        User user = userService.findUserByNameAndLastNameAndDate(name, lastName, userBirthDate);
        Route trainRoute = routeService.findRouteByCode(route);
        Train train = trainService.findTrainByRoute(trainRoute);
        Ticket ticket = ticketService.findTicketByUserAndRoute(user, trainRoute);

        if ((ticket == null) || train.getSeatsCount() > 0) {
            ticketService.persistTicket(new Ticket(trainRoute, user));
            train.setSeatsCount(train.getSeatsCount() - 1);
            trainService.updateTrain(train);
        }

        model.addAttribute("name", name);
        model.addAttribute("lastName", lastName);
        model.addAttribute("route", route);
        model.addAttribute("stationFrom", stationFrom);
        model.addAttribute("stationTo", stationTo);
        model.addAttribute("departureDate", departureDate);
        model.addAttribute("arrivalDate", arrivalDate);

        return "result";
    }

}
