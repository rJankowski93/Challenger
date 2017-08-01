package com.aghpk.challenger.repository;

import com.aghpk.challenger.data.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> getUserRolesByUserId(Long userId);

    List<String> getRolesByUserId(Long userId);
}
