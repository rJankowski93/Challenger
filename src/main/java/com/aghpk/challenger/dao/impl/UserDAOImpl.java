package com.aghpk.challenger.dao.impl;

import com.aghpk.challenger.data.User;
import com.aghpk.challenger.data.UserRole;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public class UserDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public User createUser(User user) {
        user.setAuditCD(new Date());
        //TODO encode password
        entityManager.persist(user);
        return user;
    }

    public void removeUser(User user) {
        user.setAuditRD(new Date());
        user.setEnabled(false);
        entityManager.merge(user);
    }

    public void removeUser(Long id) {
        User user = entityManager.find(User.class, id);
        user.setAuditRD(new Date());
        user.setEnabled(false);
        entityManager.merge(user);
    }

    public List<User> getAll() {
        String queryTxt = "SELECT item FROM User item WHERE item.auditRD IS NULL";
        TypedQuery<User>  query = entityManager.createQuery(queryTxt, User.class);
        return query.getResultList();
    }
}
