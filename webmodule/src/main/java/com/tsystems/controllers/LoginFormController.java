package com.tsystems.controllers;

import com.javaschool.entity.Station;
import com.javaschool.entity.User;
import com.javaschool.services.StationService;
import com.javaschool.services.UserService;
import com.tsystems.utils.HashConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by bugav on 01.10.2017.
 */
@Controller
public class LoginFormController {

    private final static Logger logger = Logger.getLogger(LoginFormController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private StationService stationService;

    @Autowired
    private HashConverter hashConverter;


    @RequestMapping(value = "/validateLoginForm", method = RequestMethod.POST)
    public String validateForm(@RequestParam(value = "email") String email,
                               @RequestParam(value = "password") String password,
                               Model model) {
        logger.info("user email from login page is:" + email);
        logger.info("user hashed password from login page is:" + password);

        List<Station> stations = stationService.getAllStations();

        List<User> users = userService.findUserByEmailAndPassword(email, hashConverter.hashPassword(password));

        if (!users.isEmpty()) {

            model.addAttribute("user", users.get(0));
            model.addAttribute("stations", stations);
            return "homePage.jsp";
        }
        return "errorPage.jsp";
    }

}
