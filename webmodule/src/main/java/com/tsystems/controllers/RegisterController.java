package com.tsystems.controllers;

import com.javaschool.entity.User;
import com.javaschool.services.UserService;
import com.tsystems.utils.DateTimeComponent;
import com.tsystems.utils.DateTimePatterns;
import com.tsystems.utils.HashConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by bugav on 15.10.2017.
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private DateTimeComponent converter;

    @Autowired
    private HashConverter hashConverter;


    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerUser(@RequestParam(value = "name") String name,
                               @RequestParam(value = "lastname") String lastName,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value = "birthdate") String birthDate,
                               @RequestParam(value = "password") String password,
                               Model model) {


        Date userBirthDate = converter.convertStringToDate(birthDate, DateTimePatterns.COMMON_DATE_WITHOUT_TIME_AMERICAN.getValue());

        boolean created;

        List<User> users = userService.findUserByNameAndLastNameAndDate(name, lastName, userBirthDate);

        if (users.isEmpty()) {
            userService.persistUser(new User(name, lastName, email, hashConverter.hashPassword(password), userBirthDate, false));
            created = true;
            model.addAttribute("created", created);
        } else {
            return "register";
        }
        return "register";
    }

}
