package com.aghpk.challenger.service;

import com.aghpk.challenger.data.Notification;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.model.CustomUserDetails;
import com.aghpk.challenger.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    private final SenderNotification senderNotification;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, SenderNotification senderNotification) {
        this.notificationRepository = notificationRepository;
        this.senderNotification = senderNotification;
    }

    public List<Notification> getNotificationsForLoggedUser(final Authentication authentication) {
        return notificationRepository.getNotificationsByUser(((CustomUserDetails) authentication.getPrincipal()).getUser().getId());
    }

    public void sendNotification(Notification.Type type, User creator, User subject) {
        senderNotification.sendMessage(createNotification(type, creator, subject));
    }

    private Notification createNotification(Notification.Type type, User creator, User subject) {
        String message = generateMessage(type, creator);
        return notificationRepository.save(new Notification(type, message, creator, subject));
    }

    private String generateMessage(Notification.Type type, User creator) {
        switch (type) {
            case CHALLENGE_ACCEPTANCE:
                return creator.getFirstName() + " accepted your challenge";
            case CHALLENGE_INVITATION:
                return creator.getFirstName() + " challenge you";
            case CHALLENGE_REFUSE:
                return creator.getFirstName() + " didn't your challenge";
            case CHALLENGE_SUCCESS:
                return creator.getFirstName() + " did your challenge";
            case FRIEND_ACCEPTANCE:
                return creator.getFirstName() + " accepted your invitation to friend";
            case FRIEND_INVITATION:
                return creator.getFirstName() + " invited you to friends";
            default:
                return "Wrong type of challenge";
        }
    }
}
