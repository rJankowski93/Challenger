package com.aghpk.challenger.api;

import com.aghpk.challenger.dao.ChallengeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/challenges")
public class ChallengesResources {

    private final ChallengeRepository challengeRepository;

    public ChallengesResources(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @RequestMapping("/list")
    public String getChallenges() {
        return "All challenges";
    }

    @RequestMapping("/challenge")
    public String getChallenger() {
        return "One challenger";
    }
}
