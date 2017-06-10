package com.aghpk.challenger.repository.impl;

import com.aghpk.challenger.data.Notification;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class NotificationRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Notification> getAll() {
        String queryTxt = "SELECT item FROM Notification item WHERE item.auditRD IS NULL";
        TypedQuery<Notification> query = entityManager.createQuery(queryTxt, Notification.class);
        return query.getResultList();
    }
}
