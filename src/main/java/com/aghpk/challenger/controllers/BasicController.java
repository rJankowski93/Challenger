package com.aghpk.challenger.controllers;

import com.aghpk.challenger.data.User;
import com.aghpk.challenger.data.UserRole;
import com.aghpk.challenger.model.CustomUserDetails;
import com.aghpk.challenger.model.JsonRegisterForm;
import com.aghpk.challenger.model.JsonResponseBody;
import com.aghpk.challenger.model.Views;
import com.aghpk.challenger.service.CustomUserDetailsService;
import com.fasterxml.jackson.annotation.JsonView;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class BasicController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String home(@RequestParam(value = "error", required = false) String error,
                       @RequestParam(value = "logout", required = false) String logout) {
        return "index.html";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "index.html";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @JsonView(Views.Public.class)
    public
    @ResponseBody
    JsonResponseBody registrationProcess(@RequestBody JsonRegisterForm registerForm) {
        JsonResponseBody result = new JsonResponseBody();
        User user = customUserDetailsService.registrationUser(registerForm);
        result.setResult(new ArrayList<>(Arrays.asList(user)));
        return result;
    }
}
