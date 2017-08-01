package com.aghpk.challenger.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class NotificationRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    List<Object[]> getNotificationsByUser(Long subjectId) {
        String queryTxt = "SELECT item FROM Notification item WHERE item.subjectId =:subjectId AND item.auditRD IS NULL ";
        TypedQuery<Object[]> query = entityManager.createQuery(queryTxt, Object[].class);
        query.setParameter("subjectId", subjectId);
        return query.getResultList();
    }
}
