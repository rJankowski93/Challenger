package com.aghpk.challenger.dao.impl;

import com.aghpk.challenger.data.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class UserDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public User createUser(User user) {
        //TODO create field registraionDate
        //user.setRegistrationDate(new Date());
        //TODO encode password
        entityManager.persist(user);
        return user;
    }
}
