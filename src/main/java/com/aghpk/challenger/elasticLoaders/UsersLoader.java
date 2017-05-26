package com.aghpk.challenger.elasticLoaders;

import com.aghpk.challenger.repository.UserRepository;
import com.aghpk.challenger.repositoryElastic.UserElasticRepository;
import com.aghpk.challenger.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Transactional
public class UsersLoader {

    private final ElasticsearchTemplate elasticsearchTemplate;
    private final UserRepository userRepository;
    private final UserElasticRepository userElasticRepository;

    @Autowired
    public UsersLoader(ElasticsearchTemplate elasticsearchTemplate, UserRepository userRepository, UserElasticRepository userElasticRepository) {
        this.elasticsearchTemplate = elasticsearchTemplate;
        this.userRepository = userRepository;
        this.userElasticRepository = userElasticRepository;
    }

    @PostConstruct
    @Transactional
    private void loadAll(){
        elasticsearchTemplate.createIndex(User.class);
        List<User> users= userRepository.findAll();
        userElasticRepository.save(users);
    }
}
