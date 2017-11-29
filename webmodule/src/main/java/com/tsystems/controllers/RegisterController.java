package com.tsystems.controllers;

import com.javaschool.entity.User;
import com.javaschool.services.UserService;
import com.tsystems.utils.DateTimeComponent;
import com.tsystems.utils.DateTimePatterns;
import com.tsystems.utils.PasswordHashConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Controller that manages register menu
 */
@Controller
public class RegisterController {

    private static final Logger logger = Logger.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private DateTimeComponent converter;

    @Autowired
    private PasswordHashConverter hashConverter;

    /**
     * Registers user
     *
     * @param name    - name of user
     * @param lastName - last name of user
     * @param email - email of user
     * @param birthDate - users birth of date
     * @param password - password of user
     * @return name of register.jsp
     */
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerUser(@RequestParam(value = "name") String name,
                               @RequestParam(value = "lastname") String lastName,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value = "birthdate") String birthDate,
                               @RequestParam(value = "password") String password,
                               Model model) {

        logParamsRegisterUser(name, lastName, email, birthDate);

        Date userBirthDate = converter.convertStringToDate(birthDate, DateTimePatterns.DATE_WITHOUT_TIME_AMERICAN.getValue());


        User user = userService.findUserByNameAndLastNameAndDate(name, lastName, userBirthDate);

        if (user == null) {
            userService.persistUser(new User(name, lastName, email, hashConverter.hashPassword(password), userBirthDate, false));
        } else {
            return "register.jsp";
        }
        return "register.jsp";
    }

    private void logParamsRegisterUser(String name, String lastName, String email, String birthDate) {

        logger.info("------------------------------------------------");
        logger.info("|RegisterController class|, |registerUser method|, |user name param| is:" + name);
        logger.info("|RegisterController class|, |registerUser method|, |user lastname param| is:" + lastName);
        logger.info("|RegisterController class|, |registerUser method|, |user email param| is:" + email);
        logger.info("|RegisterController class|, |registerUser method|, |user birthDate param| is:" + birthDate);
        logger.info("------------------------------------------------");

    }

}
