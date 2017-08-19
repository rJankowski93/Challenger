package com.aghpk.challenger.repository;

import com.aghpk.challenger.data.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> getNotificationsByUser(Long subjectId);

    void changeStatus(Long notificationId, Notification.Status status);
}
