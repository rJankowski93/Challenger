package com.aghpk.challenger.dao;

import com.aghpk.challenger.data.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findUserRolesByUserId(Long userId);

    List<String> findRolesByUserId(Long userId);
}
