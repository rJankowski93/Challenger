package com.aghpk.challenger.repository.impl;

import com.aghpk.challenger.data.UserRole;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserRoleRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    List<String> findRolesByUserId(Long userId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);
        Root<UserRole> item = cq.from(UserRole.class);
        Expression<String> name = item.get("userId");
        Predicate eq1 = cb.equal(name, userId);
        cq.multiselect(item.get("role")).where(eq1);
        return entityManager.createQuery(cq).getResultList();
    }
}
