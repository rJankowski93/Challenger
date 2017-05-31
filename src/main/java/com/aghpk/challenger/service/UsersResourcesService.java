package com.aghpk.challenger.service;

import com.aghpk.challenger.data.User;
import com.aghpk.challenger.repositoryElastic.UserElasticRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersResourcesService {

    private final UserElasticRepository userElasticRepository;

    public UsersResourcesService(UserElasticRepository userElasticRepository) {
        this.userElasticRepository = userElasticRepository;
    }


    public List<User> getTopUsersByPointsQuantity(int pageNo, int pageSize, String pointsType) {
        return userElasticRepository.findAll(
                new PageRequest(pageNo, pageSize,
                        new Sort(Sort.Direction.DESC, pointsType)))
                .getContent();
    }
}