package com.aghpk.challenger.service;

import com.aghpk.challenger.data.Notification;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.repository.NotificationRepository;
import com.aghpk.challenger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    private final UserRepository userRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    public void createNotification(String type, Long creatorId, Long subjectId) {
        User creator = userRepository.getUserById(creatorId);
        User subject = userRepository.getUserById(subjectId);
        notificationRepository.save(new Notification(type, generateMessage(type, creator), generateLink(type, creator, subject), creator, subject));

    }

    private String generateMessage(String type, User creator) {
        String message = "";
        switch (type) {
            case Notification.TYPE.CHALLENGE_ACCEPTANCE:
                //TODO
                break;
            case Notification.TYPE.CHALLENGE_INVITATION:
                //TODO
                break;
            case Notification.TYPE.CHALLENGE_REFUSE:
                //TODO
                break;
            case Notification.TYPE.CHALLENGE_SUCCESS:
                //TODO
                break;
            case Notification.TYPE.FRIEND_ACCEPTANCE:
                //TODO
                break;
            case Notification.TYPE.FRIEND_INVITATION:
                message = creator.getFirstName() + "invite you to friends";
                break;
        }
        return message;
    }

    private String generateLink(String type, User creator, User subject) {
        String link = "";
        return link;
    }

}
