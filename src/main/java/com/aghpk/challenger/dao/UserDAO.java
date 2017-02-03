package com.aghpk.challenger.dao;

import com.aghpk.challenger.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User findUserByFirstname(String username);

    User findUserById(Long id);

    List<User> findAll();
}
