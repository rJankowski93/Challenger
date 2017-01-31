package com.aghpk.challenger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {

    @RequestMapping("/")
    public String home(){
        return "index.html";
    }
}
