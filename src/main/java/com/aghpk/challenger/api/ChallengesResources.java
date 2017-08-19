package com.aghpk.challenger.api;

import com.aghpk.challenger.data.Challenge;
import com.aghpk.challenger.data.ChallengeCategory;
import com.aghpk.challenger.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/challenges")
public class ChallengesResources {

    private final ChallengeService challengeService;

    @Autowired
    public ChallengesResources(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @RequestMapping("/list")
    public
    @ResponseBody
    List<Challenge> getChallenges() {
        return challengeService.getChallenges();
    }

    @RequestMapping(value = "/challenge", produces = "application/json")
    public Challenge getChallenge(@RequestParam("id") Long id) {
        return challengeService.getChallenge(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addChallenge(@RequestBody Challenge challenge) {
        challengeService.addChallenge(challenge);
    }

    @RequestMapping("/user/challenges")
    public
    @ResponseBody
    List<Challenge> getChallengesByUser(@RequestParam(value = "id", required = false) Long userId) {
        return challengeService.getChallengesByUser(userId);
    }

    @RequestMapping(value = "/categories")
    public
    @ResponseBody
    List<ChallengeCategory> getCategories() {
        return challengeService.getCategories();
    }

    @RequestMapping(value = "/acceptChallenge", produces = "application/json")
    public void acceptChallenge(@RequestParam("notificationId") Long notificationId, @RequestParam("challengeId") Long challengeId) {
        challengeService.acceptChallenge(notificationId, challengeId);
    }

    @RequestMapping(value = "/rejectChallenge", produces = "application/json")
    public void rejectChallenge(@RequestParam("notificationId") Long notificationId, @RequestParam("challengeId") Long challengeId) {
        challengeService.rejectChallenge(notificationId, challengeId);
    }

}