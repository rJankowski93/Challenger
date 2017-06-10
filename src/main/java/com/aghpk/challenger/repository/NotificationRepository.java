package com.aghpk.challenger.repository;

import com.aghpk.challenger.data.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    //Notification save(Notification notification);

    List<Notification> getNotificationsByUser(Long userId);
}
