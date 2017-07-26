package com.aghpk.challenger.service;

import com.aghpk.challenger.data.Notification;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.model.CustomUserDetails;
import com.aghpk.challenger.model.JsonRegisterForm;
import com.aghpk.challenger.model.JsonResponseBody;
import com.aghpk.challenger.repository.UserRepository;
import com.aghpk.challenger.repositoryElastic.UserElasticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final CustomUserDetailsService customUserDetailsService;

    private final UploadFileService uploadFileService;

    private final UserElasticRepository userElasticRepository;

    private final NotificationService notificationService;

    @Autowired
    public UserService(UserRepository userRepository, CustomUserDetailsService customUserDetailsService, UploadFileService uploadFileService, UserElasticRepository userElasticRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.customUserDetailsService = customUserDetailsService;
        this.uploadFileService = uploadFileService;
        this.userElasticRepository = userElasticRepository;
        this.notificationService = notificationService;
    }

    public boolean isAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (authentication != null && !(authentication instanceof AnonymousAuthenticationToken));
    }

    private User getCurrentUser() {
        return ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }

    public User getLoggedUserDetails(final Authentication authentication) {
        return userRepository.getUserByLogin(authentication.getName());
    }

    public User getUser(Long id) {
        return userRepository.getUserById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void removeUser(Long id) {
        userRepository.removeUser(id);
    }

    public List<User> getFriendsByUser(Long userId) {
        return userRepository.getFriendsByUser(userId != null ? userId : getCurrentUser().getId());
    }

    public JsonResponseBody registrationProcess(JsonRegisterForm registerForm) {
        User user = customUserDetailsService.registrationUser(registerForm);
        return new JsonResponseBody(new ArrayList<>(Arrays.asList(user)));
    }

    public void confirmRegistration(Long userId, String login) {
        customUserDetailsService.activateUser(userId, login);
    }

    public void uploadImage(MultipartFile file) {
        uploadFileService.uploadImage(getCurrentUser().getId(), file);
    }

    public List<User> getTopUsers(int pageNo, int pageSize, String pointsType) {
        return userElasticRepository.findAll(
                new PageRequest(pageNo, pageSize,
                        new Sort(Sort.Direction.DESC, pointsType)))
                .getContent();
    }

    public void removeFriend(Long friendId) {
        User user = userRepository.getUserById(getCurrentUser().getId());
        User friendUser = userRepository.getUserById(friendId);
        user.getFriends().remove(friendUser);
        friendUser.getFriends().remove(user);
    }

    public void inviteFriend(Long friendId) {
        //TODO check if user has already this friend
        notificationService.sendNotification(Notification.Type.FRIEND_INVITATION, getCurrentUser(), getUser(friendId));
    }

    public void acceptInvitation(Long friendId) {
        //TODO check if user has already this friend
        User friendUser = userRepository.getUserById(friendId);
        getCurrentUser().getFriends().add(friendUser);
        friendUser.getFriends().add(getCurrentUser());
        notificationService.sendNotification(Notification.Type.FRIEND_ACCEPTANCE, getCurrentUser(), getUser(friendId));
    }


}