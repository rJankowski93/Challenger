package com.aghpk.challenger.api;

import com.aghpk.challenger.data.Notification;
import com.aghpk.challenger.repository.NotificationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationResources {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationResources(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    @RequestMapping("/")
    public
    @ResponseBody
    List<Notification> getNotifications(@RequestParam("id") Long id) throws JsonProcessingException {
        //TODO change on get notificstions for user
        return notificationRepository.getAll();
    }

}
