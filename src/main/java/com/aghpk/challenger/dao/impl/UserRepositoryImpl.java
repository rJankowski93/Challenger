package com.aghpk.challenger.dao.impl;

import com.aghpk.challenger.data.User;
<<<<<<< HEAD:src/main/java/com/aghpk/challenger/dao/impl/UserDAOImpl.java
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> e87ace2c836317a9264b5699676128532304ff5f:src/main/java/com/aghpk/challenger/dao/impl/UserRepositoryImpl.java
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

    public UserRepositoryImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

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

    List<Object[]> getFriendsByUser(Long id){
        String queryTxt = "SELECT item.friends FROM User item WHERE item.id =:id AND item.auditRD IS NULL ";
        TypedQuery<Object[]>  query = entityManager.createQuery(queryTxt,Object[].class);
        query.setParameter("id",id);
        return query.getResultList();
    }
}
