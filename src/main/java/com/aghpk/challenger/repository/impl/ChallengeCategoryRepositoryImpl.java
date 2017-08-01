package com.aghpk.challenger.repository.impl;

import com.aghpk.challenger.data.ChallengeCategory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class ChallengeCategoryRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ChallengeCategory> getAll() {
        String queryTxt = "SELECT item FROM ChallengeCategory item";
        TypedQuery<ChallengeCategory> query = entityManager.createQuery(queryTxt, ChallengeCategory.class);
        return query.getResultList();
    }
}
