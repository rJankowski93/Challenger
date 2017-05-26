package com.aghpk.challenger.api;

import com.aghpk.challenger.repository.ChallengeRepository;
import com.aghpk.challenger.data.Challenge;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/challenges")
public class ChallengesResources {

    private final ChallengeRepository challengeRepository;

    @Autowired
    public ChallengesResources(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @RequestMapping("/list")
    public
    @ResponseBody
    List<Challenge> getChallenges() throws JsonProcessingException {
        return challengeRepository.getAll();
    }

    @RequestMapping("/challenge/{id}")
    public Challenge getChallenge(@PathVariable("id") Long id) {
        return challengeRepository.findChallengeById(id);
    }

    @RequestMapping(value = "/add/",method = RequestMethod.POST)
    public void addChallenge(@RequestBody Challenge challenge){
        challengeRepository.save(challenge);
    }
}