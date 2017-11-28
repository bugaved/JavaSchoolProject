package com.tsystems.controllers;

import com.javaschool.entity.Station;
import com.javaschool.entity.User;
import com.javaschool.services.StationService;
import com.javaschool.services.UserService;
import com.tsystems.utils.PasswordHashConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Controller that rules login form
 */
@Controller
public class LoginFormController {

    private final static Logger logger = Logger.getLogger(LoginFormController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private StationService stationService;

    @Autowired
    private PasswordHashConverter hashConverter;

    /**
     * Checks user parameters for login
     *
     * @param email    - email of user
     * @param password - password of user
     * @return name of errorPage.jsp if acess denied or name of homePage.jsp if acess allowed
     */
    @RequestMapping(value = "/validateLoginForm", method = RequestMethod.POST)
    public String validateForm(@RequestParam(value = "email") String email,
                               @RequestParam(value = "password") String password,
                               Model model) {

        logParamsLoginForm(email);

        List<Station> stations = stationService.getAllStations();

        List<User> users = userService.findUserByEmailAndPassword(email, hashConverter.hashPassword(password));

        if (!users.isEmpty()) {

            model.addAttribute("user", users.get(0));
            model.addAttribute("stations", stations);
            return "homePage.jsp";
        }
        return "errorPage.jsp";
    }

    private void logParamsLoginForm(String email) {

        logger.info("------------------------------------------------");
        logger.info("|LoginFormController class|, |validateForm method|, |user email param| is:" + email);
        logger.info("------------------------------------------------");

    }
}
