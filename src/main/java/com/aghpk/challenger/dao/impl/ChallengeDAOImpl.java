package com.aghpk.challenger.dao.impl;

import com.aghpk.challenger.data.Challenge;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class ChallengeDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public Challenge createChallenge(Challenge challenge) {
        //TODO create field registraionDate
        // challenge.setCreationDate(new Date());
        entityManager.persist(challenge);
        return challenge;
    }
}
