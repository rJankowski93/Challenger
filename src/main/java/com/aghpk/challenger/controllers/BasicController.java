package com.aghpk.challenger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasicController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String home(@RequestParam(value = "error", required = false) String error,
                       @RequestParam(value = "logout", required = false) String logout) {
        return "index.html";
    }
}
