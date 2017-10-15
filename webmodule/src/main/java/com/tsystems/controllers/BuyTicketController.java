package com.tsystems.controllers;

import com.javaschool.entity.Route;
import com.javaschool.entity.Ticket;
import com.javaschool.entity.User;
import com.javaschool.services.RouteService;
import com.javaschool.services.TicketService;
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
        List<User> users = userService.findUserByNameAndLastNameAndDate(name, lastName, userBirthDate);
        List<Route> routes = routeService.findRouteByCode(route);
       ticketService.persistTicket(new Ticket(routes.get(0), users.get(0)));

        return "result";

    }

}
