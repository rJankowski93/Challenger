package com.aghpk.challenger.dao.impl;

import com.aghpk.challenger.data.User;
import com.aghpk.challenger.exeption.ApplicationException;
import com.aghpk.challenger.exeption.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public class UserDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser(User user) throws EntityExistsException{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
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
