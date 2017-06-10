package com.aghpk.challenger.repository;

import com.aghpk.challenger.data.Notification;
import com.aghpk.challenger.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<User, Long> {

    List<Notification> getAll();
}
