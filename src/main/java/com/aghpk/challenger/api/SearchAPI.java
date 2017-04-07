package com.aghpk.challenger.api;

import com.aghpk.challenger.daoElastic.ChallengeElasticDAO;
import com.aghpk.challenger.data.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class SearchAPI {

    private final ChallengeElasticDAO challengeElasticDAO;

    @Autowired
    public SearchAPI(ChallengeElasticDAO challengeElasticDAO) {
        this.challengeElasticDAO = challengeElasticDAO;
    }

    @RequestMapping("/challenge")
    public Page<Challenge> findChallenges(@RequestParam("filter") String filter){
        return challengeElasticDAO.findByNameContainingOrDescriptionContaining(filter, filter, new PageRequest(0,5));
    }
}
