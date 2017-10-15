package com.tsystems.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BuyTicketController {

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



        return "result";

    }

}
