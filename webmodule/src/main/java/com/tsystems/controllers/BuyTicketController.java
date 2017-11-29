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
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Controller that manages buying ticket
 */
@Controller
public class BuyTicketController {

    private static final Logger logger = Logger.getLogger(BuyTicketController.class);


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

    /**
     * Realises buying of required ticket with required user
     *
     * @param name   - name of user
     * @param lastName     - last name of user
     * @param birthDate   - birth date of user
     * @param route - route of ticket
     * @param stationFrom - departure station of ticket
     * @param stationTo - arrival station of ticket
     * @param departureDate - departure date of ticket
     * @param arrivalDate - arrival date of ticket
     * @return name of ticket.jsp page
     */
    @RequestMapping(value = "/buyTicket", method = RequestMethod.GET)
    public String buyTicket(@RequestParam(value = "name") String name,
                            @RequestParam(value = "lastName") String lastName,
                            @RequestParam(value = "birthDate") String birthDate,
                            @RequestParam(value = "route") String route,
                            @RequestParam(value = "stationFrom") String stationFrom,
                            @RequestParam(value = "stationTo") String stationTo,
                            @RequestParam(value = "departureDate") String departureDate,
                            @RequestParam(value = "arrivalDate") String arrivalDate,
                            Model model) {

        logParamsBuyTicket(name, lastName, route, stationFrom, stationTo, departureDate, arrivalDate);

        Date userBirthDate = converter.convertStringToDate(birthDate, DateTimePatterns.DATE_WITHOUT_TIME_AMERICAN.getValue());

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

        return "ticket.jsp";
    }

    private void logParamsBuyTicket(String name, String lastName, String route,
                                    String stationFrom, String stationTo, String departureDate, String arrivalDate) {

        logger.info("------------------------------------------------");
        logger.info("|BuyTicketController class|, |buyTicket method|, |ticket owner name param| is:" + name);
        logger.info("|BuyTicketController class|, |buyTicket method|, |ticket owner lastname param| is:" + lastName);
        logger.info("|BuyTicketController class|, |buyTicket method|, |ticket route param| is:" + route);
        logger.info("|BuyTicketController class|, |buyTicket method|, |ticket departure station param| is:" + stationFrom);
        logger.info("|BuyTicketController class|, |buyTicket method|, |ticket arrival station param| is:" + stationTo);
        logger.info("|BuyTicketController class|, |buyTicket method|, |ticket departure date param| is:" + departureDate);
        logger.info("|BuyTicketController class|, |buyTicket method|, |ticket arrival date param| is:" + arrivalDate);
        logger.info("------------------------------------------------");

    }

}
