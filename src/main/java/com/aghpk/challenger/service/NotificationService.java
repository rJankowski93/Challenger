package com.aghpk.challenger.service;

import com.aghpk.challenger.data.Notification;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    private final SenderNotification senderNotification;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, SenderNotification senderNotification) {
        this.notificationRepository = notificationRepository;
        this.senderNotification = senderNotification;
    }

    public void sendNotification(Notification.Type type, User creator, User subject) {
        senderNotification.sendMessage(createNotification(type, creator, subject));
    }

    private Notification createNotification(Notification.Type type, User creator, User subject) {
        String detailsLink = generateLink(type, creator, subject);
        String message = generateMessage(type, creator);
        return notificationRepository.save(new Notification(type, message, detailsLink, creator, subject));
    }

    private String generateMessage(Notification.Type type, User creator) {
        String message = "";
        switch (type) {
            case CHALLENGE_ACCEPTANCE:
                //TODO
                break;
            case CHALLENGE_INVITATION:
                //TODO
                break;
            case CHALLENGE_REFUSE:
                //TODO
                break;
            case CHALLENGE_SUCCESS:
                //TODO
                break;
            case FRIEND_ACCEPTANCE:
                //TODO
                break;
            case FRIEND_INVITATION:
                message = creator.getFirstName() + "invite you to friends";
                break;
        }
        return message;
    }

    private String generateLink(Notification.Type type, User creator, User subject) {
        String link = "";
        return link;
    }

}
