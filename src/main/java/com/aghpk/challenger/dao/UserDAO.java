package com.aghpk.challenger.dao;

import com.aghpk.challenger.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    //CRUD
    User createUser(User user);

    User findUserById(Long id);

    User save(User user);

    void delete(Long id);

    //FIND
    List<User> findAll();

    List<User> findUsersByLogin(String login);

    List<User> findUsersByFirstnameAndLastname(String firstname, String lastname);

    long count();
}
