package com.aghpk.challenger.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;

@Transactional
public class ChallengeDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public Challenge createChallenge(Challenge challenge) {
        challenge.setCreationDate(new Date());
        entityManager.persist(challenge);
        return challenge;
    }
}
