package com.aghpk.challenger.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengesResources {

    @RequestMapping("/api/challenges")
    public String getAllChallenges(){
        return "All challenges";
    }
}
