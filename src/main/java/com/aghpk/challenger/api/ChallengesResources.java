package com.aghpk.challenger.api;

import com.aghpk.challenger.dao.ChallengeDAO;
import com.aghpk.challenger.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengesResources {

    @Autowired
    UserDAO userDAO;

    @Autowired
    ChallengeDAO challengeDAO;

    @RequestMapping("/api/challenges")
    public String getAllChallenges() {
        return userDAO.findAll().toString();
    }
}
