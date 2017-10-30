package com.tsystems.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bugav on 30.09.2017.
 */
@Controller
public class SomeController {


    @RequestMapping("/home")
    public String redirectToMainPage() {
        return "home";
    }
}

