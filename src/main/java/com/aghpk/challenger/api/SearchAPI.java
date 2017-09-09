package com.aghpk.challenger.api;

import com.aghpk.challenger.data.Challenge;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.model.GlobalSearchResult;
import com.aghpk.challenger.repositoryElastic.ChallengeElasticRepository;
import com.aghpk.challenger.repositoryElastic.UserElasticRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
public class SearchAPI {

    private static final int defaultPageNo = 0;
    private static final int defaultPageSize = 5;

    private final ChallengeElasticRepository challengeElasticRepository;
    private final UserElasticRepository userElasticRepository;

    @Autowired
    public SearchAPI(ChallengeElasticRepository challengeElasticRepository, UserElasticRepository userElasticRepository) {
        this.challengeElasticRepository = challengeElasticRepository;
        this.userElasticRepository = userElasticRepository;
    }

    @ApiOperation(value = "Get challenges search result.", response = Page.class)
    @RequestMapping(value = "/challenges", method = RequestMethod.GET)
    public Page<Challenge> findChallenges(@RequestParam("filter") String filter, @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        return challengeElasticRepository.findByNameContainingOrDescriptionContaining(filter, filter, new PageRequest(pageNo,pageSize));
    }

    @ApiOperation(value = "Get users search result.", response = Page.class)
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Page<User> findUsers(@RequestParam("filter") String filter, @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        return userElasticRepository.findByFirstNameContainingOrLastNameContaining(filter, filter, new PageRequest(pageNo, pageSize));
    }

    @ApiOperation(value = "Get global search result.", response = GlobalSearchResult.class)
    @RequestMapping(value = "/global", method = RequestMethod.GET)
    @ResponseBody
    public GlobalSearchResult findChallengesAndUsers(@RequestParam("filter") String filter) {
        return new GlobalSearchResult(
                challengeElasticRepository.findByNameContainingOrDescriptionContaining(filter, filter, new PageRequest(defaultPageNo, defaultPageSize)).getContent(),
                userElasticRepository.findByFirstNameContainingOrLastNameContaining(filter, filter, new PageRequest(defaultPageNo, defaultPageSize)).getContent()
        );
    }
}
