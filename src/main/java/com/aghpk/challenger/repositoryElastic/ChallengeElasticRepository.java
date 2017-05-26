package com.aghpk.challenger.repositoryElastic;

import com.aghpk.challenger.data.Challenge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ChallengeElasticRepository extends ElasticsearchRepository<Challenge, Long> {
    List<Challenge> findByNameContaining(String name);

    Page<Challenge> findByNameContainingOrDescriptionContaining(String name, String description, Pageable pageable);
}
