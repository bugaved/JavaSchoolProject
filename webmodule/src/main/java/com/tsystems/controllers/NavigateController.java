package com.tsystems.controllers;

import com.javaschool.entity.*;
import com.javaschool.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
        return "login";
    }

    @RequestMapping("/home")
    public String redirectToHomePage(Model model) {

        List<Station> stations = stationService.getAllStations();
        model.addAttribute("stations", stations);

        return "homePage";
    }

    @RequestMapping("/logout")
    public String redirectToLoginPage(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        user.setAdmin(false);
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping("/admin")
    public String redirectToAdminPage(Model model) {

        List<Station> actualStations = stationService.getAllStations();
        List<Train> actualTrains = trainService.getAllTrains();
        List<Waypoint> actualWaypoints = waypointService.getAllWaypoints();

        model.addAttribute("actualTrains", actualTrains);
        model.addAttribute("actualStations", actualStations);
        model.addAttribute("actualWaypoints", actualWaypoints);

        return "adminPage";
    }

    @RequestMapping("/mytickets")
    public String redirectToMyTicketsPage(@RequestParam(value = "id") String id,
                                          Model model) {

        User user = userService.findById(Long.parseLong(id));

        List<Ticket> tickets = ticketService.findTicketsByUser(user);

        model.addAttribute("tickets", tickets);
        return "myTickets";
    }

    @RequestMapping("/register")
    public String redirectToRegisterPage() {
        return "register";
    }

    @RequestMapping("/schedule")
    public String redirectToSchedulePage() {
        return "schedule";
    }

    @RequestMapping("/purchase")
    public String redirectToPurchasePage(@RequestParam(value = "code") String code,
                                         @RequestParam(value = "stationFrom") String stationFrom,
                                         @RequestParam(value = "stationTo") String stationTo,
                                         @RequestParam(value = "departureTime") String departureTime,
                                         @RequestParam(value = "arrivalTime") String arrivalTime,
                                         Model model) {

        model.addAttribute("code", code);
        model.addAttribute("stationFrom", stationFrom);
        model.addAttribute("stationTo", stationTo);
        model.addAttribute("departureTime", departureTime);
        model.addAttribute("arrivalTime", arrivalTime);


        return "purchase";
    }

}
