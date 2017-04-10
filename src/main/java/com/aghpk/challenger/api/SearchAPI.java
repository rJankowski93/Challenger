package com.aghpk.challenger.api;

import com.aghpk.challenger.daoElastic.ChallengeElasticRepository;
import com.aghpk.challenger.daoElastic.UserElasticRepository;
import com.aghpk.challenger.data.Challenge;
import com.aghpk.challenger.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class SearchAPI {

    private final ChallengeElasticRepository challengeElasticRepository;
    private final UserElasticRepository userElasticRepository;

    @Autowired
    public SearchAPI(ChallengeElasticRepository challengeElasticRepository, UserElasticRepository userElasticRepository) {
        this.challengeElasticRepository = challengeElasticRepository;
        this.userElasticRepository = userElasticRepository;
    }

    @RequestMapping("/shortlist/challenges")
    public Page<Challenge> findChallenges(@RequestParam("filter") String filter){
        return challengeElasticRepository.findByNameContainingOrDescriptionContaining(filter, filter, new PageRequest(0,5));
    }

    @RequestMapping("/shortlist/users")
    public Page<User> findUsers(@RequestParam("filter") String filter){
        return userElasticRepository.findByFirstNameContainingOrLastnameContaining(filter, filter, new PageRequest(0, 5));
    }
}
