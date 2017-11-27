package com.tsystems.controllers;

import com.javaschool.entity.*;
import com.javaschool.services.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by bugav on 30.09.2017.
 */
@Controller
public class NavigateController {

    private final static Logger logger = Logger.getLogger(NavigateController.class);

    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;

    @Autowired
    private WaypointService waypointService;

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;


    @RequestMapping("/login")
    public String redirectToLoginPage() {
        return "login.jsp";
    }

    @RequestMapping("/access_denied")
    public String redirectToDeniedPage() {
        return "denied.jsp";
    }

    @RequestMapping("/html")
    public String redirectToHtml() {
        return "ajaxQuery.jsp";
    }

    @RequestMapping("/home")
    public String redirectToHomePage(Model model) {

        List<Station> stations = stationService.getAllStations();
        model.addAttribute("stations", stations);

        return "homePage.jsp";
    }

    @RequestMapping("/logout")
    public String redirectToLoginPage(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        user.setAdmin(false);
        model.addAttribute("user", user);
        return "login.jsp";
    }

    @RequestMapping("/admin")
    public String redirectToAdminPage(Model model) {

        List<Station> actualStations = stationService.getAllStations();
        List<Train> actualTrains = trainService.getAllTrains();
        List<Waypoint> actualWaypoints = waypointService.getAllWaypoints();

        model.addAttribute("actualTrains", actualTrains);
        model.addAttribute("actualStations", actualStations);
        model.addAttribute("actualWaypoints", actualWaypoints);

        return "adminPage.jsp";
    }

    @RequestMapping("/mytickets")
    public String redirectToMyTicketsPage(@RequestParam(value = "id") String id,

                                          Model model) {

        logParamsRedirectToMyTicketsPage(id);

        User user = userService.findById(Long.parseLong(id));

        List<Ticket> tickets = ticketService.findTicketsByUser(user);

        model.addAttribute("tickets", tickets);
        return "myTickets.jsp";
    }

    private void logParamsRedirectToMyTicketsPage(String id) {

        logger.info("------------------------------------------------");
        logger.info("|NavigateController class|, |redirectToMyTicketsPage method|, |user id param| is:" + id);
        logger.info("------------------------------------------------");

    }

    @RequestMapping("/register")
    public String redirectToRegisterPage() {
        return "register.jsp";
    }

    @RequestMapping("/schedule")
    public String redirectToSchedulePage() {
        return "schedule.jsp";
    }

    @RequestMapping("/purchase")
    public String redirectToPurchasePage(@RequestParam(value = "code") String code,
                                         @RequestParam(value = "stationFrom") String stationFrom,
                                         @RequestParam(value = "stationTo") String stationTo,
                                         @RequestParam(value = "departureTime") String departureTime,
                                         @RequestParam(value = "arrivalTime") String arrivalTime,
                                         @RequestParam(value = "price") String price,
                                         Model model) {

        logParamsRedirectToPurchasePage(code, stationFrom, stationTo, departureTime, arrivalTime);

        model.addAttribute("code", code);
        model.addAttribute("stationFrom", stationFrom);
        model.addAttribute("stationTo", stationTo);
        model.addAttribute("departureTime", departureTime);
        model.addAttribute("arrivalTime", arrivalTime);
        model.addAttribute("price", price);

        return "purchase.jsp";
    }

    private void logParamsRedirectToPurchasePage(String code, String stationFrom, String stationTo, String departureTime, String arrivalTime) {

        logger.info("------------------------------------------------");
        logger.info("|NavigateController class|, |redirectToPurchasePage method|, |departure station param| is:" + stationFrom);
        logger.info("|NavigateController class|, |redirectToPurchasePage method|, |arrival station param| is:" + stationTo);
        logger.info("|NavigateController class|, |redirectToPurchasePage method|, |departure time param| is:" + departureTime);
        logger.info("|NavigateController class|, |redirectToPurchasePage method|, |arrival time param| is:" + arrivalTime);
        logger.info("------------------------------------------------");

    }

}
