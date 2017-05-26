package com.aghpk.challenger.repository.impl;

import com.aghpk.challenger.data.Challenge;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public class ChallengeRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public Challenge createChallenge(Challenge challenge) {
        entityManager.persist(challenge);
        return challenge;
    }

    public void removeChallenge(Challenge challenge) {
        challenge.setAuditRD(new Date());
        entityManager.merge(challenge);
    }

    public void removeChallenge(Long id) {
        Challenge challenge = entityManager.find(Challenge.class, id);
        challenge.setAuditRD(new Date());
        entityManager.merge(challenge);
    }

    public List<Challenge> getAll() {
        String queryTxt = "SELECT item FROM Challenge item WHERE item.auditRD IS NULL";
        TypedQuery<Challenge> query = entityManager.createQuery(queryTxt, Challenge.class);
        return query.getResultList();
    }
}
