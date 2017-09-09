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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Challenge> getChallenges() {
        return challengeService.getChallenges();
    }

    @RequestMapping(value = "/challenge", method = RequestMethod.GET, produces = "application/json")
    public Challenge getChallenge(@RequestParam("id") Long id) {
        return challengeService.getChallenge(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addChallenge(@RequestBody Challenge challenge) {
        challengeService.addChallenge(challenge);
    }

    @RequestMapping(value = "/user/challenges", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Challenge> getChallengesByUser(@RequestParam(value = "id", required = false) Long userId) {
        return challengeService.getChallengesByUser(userId);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ChallengeCategory> getCategories() {
        return challengeService.getCategories();
    }

    @RequestMapping(value = "/acceptChallenge", method = RequestMethod.GET, produces = "application/json")
    public void acceptChallenge(@RequestParam("notificationId") Long notificationId, @RequestParam("challengeId") Long challengeId) {
        challengeService.acceptChallenge(notificationId, challengeId);
    }

    @RequestMapping(value = "/rejectChallenge", method = RequestMethod.GET, produces = "application/json")
    public void rejectChallenge(@RequestParam("notificationId") Long notificationId, @RequestParam("challengeId") Long challengeId) {
        challengeService.rejectChallenge(notificationId, challengeId);
    }

}