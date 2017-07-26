package com.aghpk.challenger.repository.impl;

import com.aghpk.challenger.data.Notification;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.service.NotificationService;
import com.aghpk.challenger.service.SenderNotification;
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
public class UserRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserRepositoryImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user) throws EntityExistsException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return entityManager.merge(user);
    }

    public void removeUser(Long id) {
        User user = entityManager.find(User.class, id);
        user.setAuditRD(new Date());
        user.setEnabled(false);
        entityManager.merge(user);
    }

    List<Object[]> getFriendsByUser(Long id) {
        String queryTxt = "SELECT item.friends FROM User item WHERE item.id =:id AND item.auditRD IS NULL ";
        TypedQuery<Object[]> query = entityManager.createQuery(queryTxt, Object[].class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
