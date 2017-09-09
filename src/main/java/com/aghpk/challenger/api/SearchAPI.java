package com.aghpk.challenger.api;

import com.aghpk.challenger.data.Challenge;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.model.GlobalSearchResult;
import com.aghpk.challenger.service.QueryBuilderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchAPI {

    private static final int defaultPageNo = 0;
    private static final int defaultPageSize = 5;

    private final ElasticsearchTemplate elasticsearchTemplate;
    private final QueryBuilderService queryBuilderService;

    @Autowired
    public SearchAPI(ElasticsearchTemplate elasticsearchTemplate, QueryBuilderService queryBuilderService) {
        this.elasticsearchTemplate = elasticsearchTemplate;
        this.queryBuilderService = queryBuilderService;
    }

    @ApiOperation(value = "Get challenges search result.", response = Page.class)
    @RequestMapping(value = "/challenges", method = RequestMethod.GET)
    public Page<Challenge> findChallenges(@RequestParam("filter") String filter, @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {
        return elasticsearchTemplate.queryForPage(
                queryBuilderService.buildMultiTermNativeSearchQuery(filter, "challenge", "challenge", pageNo, pageSize, "name", "description"),
                Challenge.class
        );
    }

    @ApiOperation(value = "Get users search result.", response = Page.class)
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Page<User> findUsers(@RequestParam("filter") String filter, @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {
        return elasticsearchTemplate.queryForPage(
                queryBuilderService.buildMultiTermNativeSearchQuery(filter, "user", "user", pageNo, pageSize, "firstName", "lastName"),
                User.class
        );
    }

    @ApiOperation(value = "Get global search result.", response = GlobalSearchResult.class)
    @RequestMapping(value = "/global", method = RequestMethod.GET)
    @ResponseBody
    public GlobalSearchResult findChallengesAndUsers(@RequestParam("filter") String filter) {
        List<Challenge> challenges = elasticsearchTemplate.queryForPage(
                queryBuilderService.buildMultiTermNativeSearchQuery(filter, "challenge", "challenge", defaultPageNo, defaultPageSize, "name", "description"),
                Challenge.class).getContent();

        List<User> users = elasticsearchTemplate.queryForPage(
                queryBuilderService.buildMultiTermNativeSearchQuery(filter, "user", "user", defaultPageNo, defaultPageSize, "firstName", "lastName"),
                User.class).getContent();

        return new GlobalSearchResult(challenges, users);
    }
}
