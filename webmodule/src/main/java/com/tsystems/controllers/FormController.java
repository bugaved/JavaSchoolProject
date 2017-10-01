package com.tsystems.controllers;

import com.javaschool.model.User;
import com.javaschool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by bugav on 01.10.2017.
 */
@Controller
public class FormController {

    @Autowired
    private UserService userService;

    @RequestMapping("/validateForm")
    public String validateForm(@RequestParam(value = "name") String name, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "password") String password) {

        User user = userService.findUserByNameAndLastNameAndPassword(name, lastName, password);

        if (user.isAdmin()) {
            return "adminPage";
        } else {
            return "userPage";
        }
    }

}
