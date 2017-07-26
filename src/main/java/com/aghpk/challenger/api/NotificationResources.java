package com.aghpk.challenger.api;

import com.aghpk.challenger.data.Notification;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.model.CustomUserDetails;
import com.aghpk.challenger.repository.NotificationRepository;
import com.aghpk.challenger.repository.UserRepository;
import com.aghpk.challenger.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationResources {

//    private final NotificationRepository notificationRepository;
//
//    private final NotificationService notificationService;
//
////    private final UserRepository userRepository;
//
//    @Autowired
//    public NotificationResources(NotificationRepository notificationRepository, NotificationService notificationService) {
//        this.notificationRepository = notificationRepository;
//        this.notificationService = notificationService;
////        this.userRepository = userRepository;
//    }
//
//    @RequestMapping("/user")
//    public
//    @ResponseBody
//    List<Notification> getNotifications(@RequestParam(value = "id", required = false) Long userId) {
//        if (userId == null) {
//            userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
//        }
//        return notificationRepository.getNotificationsByUser(userId);
//    }

//    @RequestMapping("/create")
//    public void createNotification(@RequestParam("type") String type, @RequestParam("subjectId") Long subjectId, final Authentication authentication) {
//        User creator = userRepository.getUserById(((CustomUserDetails) authentication.getPrincipal()).getUser().getId());
//        User subject = userRepository.getUserById(subjectId);
//        notificationService.createNotification(Notification.Type.valueOf(type), creator, subject);
//    }

}
