package com.aghpk.challenger.api;

import com.aghpk.challenger.dao.ChallengeDAO;
import com.aghpk.challenger.dao.UserDAO;
import com.aghpk.challenger.data.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/challenges")
public class ChallengesResources {

    @Autowired
    ChallengeDAO challengeDAO;
    
    @RequestMapping("/list")
    public String getChallenges() {
        return "All challenges";
    }

    @RequestMapping("/challenge")
    public String getChallenger() {
        return "One challenger";
    }
}
