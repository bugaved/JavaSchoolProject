package com.tsystems.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bugav on 30.09.2017.
 */
@Controller
public class NavigateController {

    @RequestMapping("/home")
    public String redirectToHomePage() {
        return "home";
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
    public String redirectToPurchasePage() {
        return "purchase";
    }

}
