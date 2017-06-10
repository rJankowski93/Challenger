package com.aghpk.challenger.repository;

import com.aghpk.challenger.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByLogin(String login);

    User getUserById(Long id);

    User createUser(User user);

    void removeUser(User user);

    void removeUser(Long id);

    List<User> getAll();

    List<User> getFriendsByUser(Long id);

    void addFriend(Long userId, Long friendId);

    void removeFriend(Long userId, Long friendId);

}
