package com.aghpk.challenger.api;

import com.aghpk.challenger.dao.ChallengeDAO;
import com.aghpk.challenger.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChallengesResources {

    @Autowired
    ChallengeDAO challengeDAO;

    @RequestMapping("/challenges")
    public String getAllChallenges() {
        return "All challenges";
    }

    @RequestMapping("/challenger")
    public String getChallenger() {
        return "One challenger";
    }
}
