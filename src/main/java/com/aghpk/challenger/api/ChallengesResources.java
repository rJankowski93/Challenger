package com.aghpk.challenger.api;

import com.aghpk.challenger.dao.ChallengeDAO;
import com.aghpk.challenger.data.Challenge;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/challenges")
public class ChallengesResources {

    private final ChallengeDAO challengeDAO;

    @Autowired
    ChallengesResources(ChallengeDAO challengeDAO) {
        this.challengeDAO = challengeDAO;
    }


    @RequestMapping("/list")
    public
    @ResponseBody
    List<Challenge> getChallenges() throws JsonProcessingException {
        List<Challenge> list = challengeDAO.getAll();
        return list;
    }

    @RequestMapping("/challenge/{id}")
    public Challenge getChallenge(@PathVariable("id") Long id) {
        Challenge challenge = challengeDAO.findChallengeById(id);
        return challenge;
    }

    @RequestMapping("/add")
    public String addChallenge() {
        return "Challenge created successfully!";
    }


}
