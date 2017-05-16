package com.aghpk.challenger.api;

import com.aghpk.challenger.dao.ChallengeDAO;
import com.aghpk.challenger.data.Challenge;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        return challengeDAO.getAll();
    }

    @RequestMapping("/challenge/{id}")
    public Challenge getChallenge(@PathVariable("id") Long id) {
        return challengeDAO.findChallengeById(id);
    }

    @RequestMapping(value = "/add/",method = RequestMethod.POST)
    public void addChallenge(@RequestBody Challenge challenge){
        challengeDAO.save(challenge);
    }
}