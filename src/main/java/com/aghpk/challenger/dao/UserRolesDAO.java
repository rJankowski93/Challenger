package com.aghpk.challenger.dao;

import com.aghpk.challenger.data.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRolesDAO extends JpaRepository<UserRole, Long> {

//    List<String> findRoleByIdUser(Long userId);
}
