package com.aghpk.challenger.controllers;

import com.aghpk.challenger.dao.UserDAO;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.model.JsonRegisterForm;
import com.aghpk.challenger.model.JsonResponseBody;
import com.aghpk.challenger.model.Views;
import com.aghpk.challenger.service.CustomUserDetailsService;
import com.aghpk.challenger.service.SendMailSSL;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class BasicController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    UserDAO userDAO;

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
