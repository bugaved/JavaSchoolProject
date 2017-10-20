package com.tsystems.controllers;

import com.javaschool.entity.Station;
import com.javaschool.entity.User;
import com.javaschool.services.StationService;
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
    private StationService stationService;


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
    public String redirectToAdminPage() {
        return "adminPage";
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
