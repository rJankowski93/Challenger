package com.aghpk.challenger.elasticLoaders;

import com.aghpk.challenger.repository.ChallengeRepository;
import com.aghpk.challenger.repositoryElastic.ChallengeElasticRepository;
import com.aghpk.challenger.data.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ChallengesLoader {

    private final ElasticsearchOperations operations;
    private final ChallengeElasticRepository challengeElasticRepository;
    private final ChallengeRepository challengeRepository;

    @Autowired
    public ChallengesLoader(ElasticsearchOperations operations, ChallengeElasticRepository challengeElasticRepository, ChallengeRepository challengeRepository) {
        this.operations = operations;
        this.challengeRepository = challengeRepository;
        this.challengeElasticRepository = challengeElasticRepository;
    }


    @PostConstruct
    @Transactional
    public void loadAll(){
        operations.putMapping(Challenge.class); //add new index type
        List<Challenge> challengeList = challengeRepository.findAll(); //Get from H2 DB
        challengeElasticRepository.save(challengeList); //loads into Elastic
    }
}
