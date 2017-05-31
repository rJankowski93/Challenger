package com.aghpk.challenger.repositoryElastic;

import com.aghpk.challenger.data.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserElasticRepository extends ElasticsearchRepository<User, Long> {

    User findByFirstNameContaining(String name);

    Page<User> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName, Pageable pageable);

    Page<User> findAll(Pageable pageable);
}
