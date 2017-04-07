package com.aghpk.challenger.elasticLoaders;

import com.aghpk.challenger.dao.ChallengeDAO;
import com.aghpk.challenger.daoElastic.ChallengeElasticDAO;
import com.aghpk.challenger.data.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Loader {

    private final ElasticsearchOperations operations;
    private final ChallengeElasticDAO challengeElasticDAO;
    private final ChallengeDAO challengeDAO;

    @Autowired
    public Loader(ElasticsearchOperations operations, ChallengeElasticDAO challengeElasticDAO, ChallengeDAO challengeDAO) {
        this.operations = operations;
        this.challengeDAO = challengeDAO;
        this.challengeElasticDAO = challengeElasticDAO;
    }


    @PostConstruct
    @Transactional
    public void loadAll(){
        operations.putMapping(Challenge.class); //add new index type
        List<Challenge> challengeList = challengeDAO.findAll(); //Get from H2 DB
        challengeElasticDAO.save(challengeList); //loads into Elastic
    }
}
