package com.aghpk.challenger.api;

import com.aghpk.challenger.data.Challenge;
import com.aghpk.challenger.data.ChallengeCategory;
import com.aghpk.challenger.service.ChallengeService;
import com.aghpk.challenger.service.FacebookService;
import com.aghpk.challenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/challenges")
public class ChallengesResources {

    private final ChallengeService challengeService;
    private final UserService userService;
    private final FacebookService facebookService;

    @Autowired
    public ChallengesResources(ChallengeService challengeService, UserService userService, FacebookService facebookService) {
        this.challengeService = challengeService;
        this.userService = userService;
        this.facebookService = facebookService;
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

    @RequestMapping(value = "/shareChallenge", method = RequestMethod.GET, produces = "application/json")
    public void shareChallenge(@RequestParam("challengeId") Long challengeId) {
        facebookService.shareChallenge(challengeId);
    }

    @RequestMapping(value = "/upvote", method = RequestMethod.GET)
    @Transactional
    public ResponseEntity<HttpStatus> upvoteChallenge(final Authentication authentication, @RequestParam("challengeId") Long challengeId) {
        Challenge challenge = challengeService.getChallenge(challengeId);

        if (challenge.getVoters().contains(userService.getCurrentUser().getId().toString())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        challenge.setVoters(challenge.getVoters() + ", " + userService.getLoggedUserDetails(authentication).getId());
        challenge.setPointsQuantity(challenge.getPointsQuantity() + 5);
        challengeService.saveChallenge(challenge);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}