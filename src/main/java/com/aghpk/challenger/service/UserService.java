package com.aghpk.challenger.service;

import com.aghpk.challenger.data.Notification;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.exceptions.ApplicationException;
import com.aghpk.challenger.exceptions.ErrorType;
import com.aghpk.challenger.model.CustomUserDetails;
import com.aghpk.challenger.model.JsonChangePasswordForm;
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
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
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

    private final ConnectionRepository connectionRepository;

    @Autowired
    private Facebook facebook;


    @Autowired
    public UserService(UserRepository userRepository, CustomUserDetailsService customUserDetailsService, UploadFileService uploadFileService, UserElasticRepository userElasticRepository, NotificationService notificationService, ConnectionRepository connectionRepository) {
        this.userRepository = userRepository;
        this.customUserDetailsService = customUserDetailsService;
        this.uploadFileService = uploadFileService;
        this.userElasticRepository = userElasticRepository;
        this.notificationService = notificationService;
        this.connectionRepository = connectionRepository;
    }

    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (connectionRepository.findPrimaryConnection(Facebook.class) != null && facebook.isAuthorized()) {
            if (userRepository.getUserByLogin(facebook.userOperations().getUserProfile().getEmail()) == null) {
                userRepository.createUserFromFacebook(facebook.userOperations().getUserProfile());
            }
            return true;
        }
        return (authentication != null && !(authentication instanceof AnonymousAuthenticationToken));
    }

    public User getCurrentUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
            return userRepository.getUserByLogin(facebook.userOperations().getUserProfile().getEmail());
        }
        return ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }

    public User getLoggedUserDetails(final Authentication authentication) {
        return authentication != null ? userRepository.getUserByLogin(authentication.getName()) : userRepository.getUserByLogin(facebook.userOperations().getUserProfile().getEmail());
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

    @Transactional
    public void removeFriend(Long friendId) {
        User user = userRepository.getUserById(getCurrentUser().getId());
        User friendUser = userRepository.getUserById(friendId);
        user.getFriends().remove(friendUser);
        friendUser.getFriends().remove(user);
    }

    public void inviteFriend(Long friendId) {
        User friendUser = getUser(friendId);
        if (getCurrentUser().getFriends().stream().anyMatch(friend -> friend.getId().equals(friendId))) {
            throw new ApplicationException(ErrorType.FRIEND_EXIST, friendUser.getFullName());
        }
        //TODO check if the notification already exist
        notificationService.sendNotification(Notification.Type.FRIEND_INVITE, getCurrentUser(), getUser(friendId), null);
    }

    @Transactional
    public void acceptInvitation(Long notificationId, Long friendId) {
        User user = userRepository.getUserById(getCurrentUser().getId());
        User friendUser = userRepository.getUserById(friendId);
        if (user.getFriends().stream().anyMatch(friend -> friend.getId().equals(friendId))) {
            throw new ApplicationException(ErrorType.FRIEND_EXIST, friendUser.getFullName());
        }
        user.getFriends().add(friendUser);
        friendUser.getFriends().add(user);
        notificationService.changeStatus(notificationId, Notification.Status.INACTIVE);
        notificationService.sendNotification(Notification.Type.ACCEPT_INVITATION, user, getUser(friendId), null);
    }

    public void rejectInvitation(Long notificationId, Long userId) {
        notificationService.changeStatus(notificationId, Notification.Status.INACTIVE);
        notificationService.sendNotification(Notification.Type.REJECT_INVITATION, getCurrentUser(), getUser(userId), null);
    }

    public void changePassword(JsonChangePasswordForm changePasswordForm) {
        customUserDetailsService.changePassword(getCurrentUser().getId(), changePasswordForm);
    }
}
