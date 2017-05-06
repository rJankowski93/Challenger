package com.aghpk.challenger.api;

import com.aghpk.challenger.dao.ChallengeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
