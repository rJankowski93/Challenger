package com.aghpk.challenger.api;

import com.aghpk.challenger.data.Notification;
import com.aghpk.challenger.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationResources {

    private final NotificationService notificationService;

    @Autowired
    public NotificationResources(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Notification> getNotificationsForLoggedUser(final Authentication authentication) {
        return notificationService.getNotificationsForLoggedUser(authentication);
    }

}
