package com.aghpk.challenger.api;

import com.aghpk.challenger.data.User;
import com.aghpk.challenger.model.JsonRegisterForm;
import com.aghpk.challenger.model.JsonResponseBody;
import com.aghpk.challenger.model.Views;
import com.aghpk.challenger.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersResources {

    private final UserService userService;

    @Autowired
    public UsersResources(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/authentication")
    public boolean isAuthentication() {
        return userService.isAuthentication();
    }

    @RequestMapping(value = "/logged/details", produces = "application/json")
    public User getLoggedUserDetails(final Authentication authentication) {
        return userService.getLoggedUserDetails(authentication);
    }

    @RequestMapping(value = "/user", produces = "application/json")
    public User getUser(@RequestParam("id") Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping("/remove")
    public void removeUser(@RequestParam("id") Long id) {
        userService.removeUser(id);
    }

    @RequestMapping("/friends")
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

    @RequestMapping(value = "/removeFriend", produces = "application/json")
    public void removeFriend(@RequestParam("friendId") Long friendId) {
        userService.removeFriend(friendId);
    }

    @RequestMapping(value = "/inviteFriend", produces = "application/json")
    public void inviteFriend(@RequestParam("friendId") Long friendId) {
        userService.inviteFriend(friendId);
    }

    @RequestMapping(value = "/acceptInvitation", produces = "application/json")
    public void acceptInvitation(@RequestParam("friendId") Long friendId) {
        userService.acceptInvitation(friendId);
    }
}
