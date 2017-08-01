package com.aghpk.challenger.repository;

import com.aghpk.challenger.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserById(Long id);

    User getUserByLogin(String login);

    User createUser(User user);

    void removeUser(Long id);

    List<User> getFriendsByUser(Long id);
}