package com.aghpk.challenger.api;

import com.aghpk.challenger.data.User;
import com.aghpk.challenger.model.JsonChangePasswordForm;
import com.aghpk.challenger.model.JsonRegisterForm;
import com.aghpk.challenger.model.JsonResponseBody;
import com.aghpk.challenger.model.Views;
import com.aghpk.challenger.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersResources {

    private final UserService userService;

    @Autowired
    public UsersResources(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/authentication", method = RequestMethod.GET)
    public boolean isAuthentication() {
        return userService.isAuthenticated();
    }

    @RequestMapping(value = "/logged/details", method = RequestMethod.GET, produces = "application/json")
    public User getLoggedUserDetails(final Authentication authentication) {
        return userService.getLoggedUserDetails(authentication);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public User getUser(@RequestParam("id") Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public void removeUser(@RequestParam("id") Long id) {
        userService.removeUser(id);
    }

    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> getFriendsByUser(@RequestParam(value = "id", required = false) Long userId) {
        return userService.getFriendsByUser(userId);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @JsonView(Views.Public.class)
    public
    @ResponseBody
    JsonResponseBody registrationProcess(@RequestBody JsonRegisterForm registerForm) {
        return userService.registrationProcess(registerForm);
    }

    @RequestMapping(value = "/confirmRegistration", method = RequestMethod.GET)
    public void confirmRegistration(@RequestParam(value = "id") Long userId, @RequestParam(value = "login") String login) {
        userService.confirmRegistration(userId, login);
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public void uploadImage(@RequestParam("file") MultipartFile file) {
        userService.uploadImage(file);
    }

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public List<User> getTopUsers(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize, @RequestParam("pointsType") String pointsType) {
        return userService.getTopUsers(pageNo, pageSize, pointsType);
    }

    @RequestMapping(value = "/removeFriend", method = RequestMethod.GET, produces = "application/json")
    public void removeFriend(@RequestParam("friendId") Long friendId) {
        userService.removeFriend(friendId);
    }

    @RequestMapping(value = "/inviteFriend", method = RequestMethod.GET, produces = "application/json")
    public void inviteFriend(@RequestParam("friendId") Long friendId) {
        userService.inviteFriend(friendId);
    }

    @RequestMapping(value = "/acceptInvitation", produces = "application/json")
    public void acceptInvitation(@RequestParam("notificationId") Long notificationId, @RequestParam("friendId") Long friendId) {
        userService.acceptInvitation(notificationId, friendId);
    }

    @RequestMapping(value = "/rejectInvitation", method = RequestMethod.GET, produces = "application/json")
    public void rejectInvitation(@RequestParam("notificationId") Long notificationId, @RequestParam("userId") Long userId) {
        userService.rejectInvitation(notificationId, userId);
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public void changePassword(@RequestBody JsonChangePasswordForm changePasswordForm) {
        userService.changePassword(changePasswordForm);
    }
}
