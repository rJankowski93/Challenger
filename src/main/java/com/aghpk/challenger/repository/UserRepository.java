package com.aghpk.challenger.repository;

import com.aghpk.challenger.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findUserByLogin(String login);

    User findUserById(Long id);

    List<User> findAll();

    User createUser(User user);

    void removeUser(User user);

    void removeUser(Long id);

    List<User> getAll();

    List<User> getFriendsByUser(Long id);
}