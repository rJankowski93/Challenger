package com.aghpk.challenger.controllers;

import com.aghpk.challenger.dao.UserJpaRepository;
import com.aghpk.challenger.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
public class BasicController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    UserJpaRepository userJpaRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String home(@RequestParam(value = "error", required = false) String error,
                       @RequestParam(value = "logout", required = false) String logout) throws MessagingException {
        return "index.html";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "index.html";
    }
}
