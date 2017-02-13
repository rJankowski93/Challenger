package com.aghpk.challenger.dao;

import com.aghpk.challenger.data.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
    List<UserRole> findUserRolesByIdUser(Long idUser);

    List<String> findRolesByIdUser(Long idUser);
}
