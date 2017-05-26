package com.aghpk.challenger.repositoryElastic;

import com.aghpk.challenger.data.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserElasticRepository extends ElasticsearchRepository<User, Long> {

    User findByFirstNameContaining(String name);
    Page<User> findByFirstNameContainingOrLastnameContaining(String firstName, String lastname, Pageable pageable);
}
