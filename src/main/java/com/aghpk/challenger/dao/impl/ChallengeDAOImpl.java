package com.aghpk.challenger.dao.impl;

import com.aghpk.challenger.data.Challenge;
import com.aghpk.challenger.data.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public class ChallengeDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public Challenge createChallenge(Challenge challenge) {
        challenge.setAuditCD(new Date());
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
