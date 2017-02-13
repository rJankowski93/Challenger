package com.aghpk.challenger.dao.impl;

import com.aghpk.challenger.data.UserRole;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserRoleDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    List<String> findRolesByIdUser(Long idUser) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);
        Root<UserRole> item = cq.from(UserRole.class);
        Expression<String> name = item.get("idUser");
        Predicate eq1 = cb.equal(name, idUser);
        cq.multiselect(item.get("role")).where(eq1);
        return entityManager.createQuery(cq).getResultList();
    }
}
