package com.aghpk.challenger.api;

import com.aghpk.challenger.data.User;
import com.aghpk.challenger.model.CustomUserDetails;
import com.aghpk.challenger.model.JsonRegisterForm;
import com.aghpk.challenger.model.JsonResponseBody;
import com.aghpk.challenger.model.Views;
import com.aghpk.challenger.repository.UserRepository;
import com.aghpk.challenger.service.CustomUserDetailsService;
import com.aghpk.challenger.service.UploadFileService;
import com.aghpk.challenger.service.UsersResourcesService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersResources {

    private final UserRepository userRepository;
    private final UsersResourcesService usersResourcesService;
    private final CustomUserDetailsService customUserDetailsService;
    private final UploadFileService uploadFileService;

    @Autowired
    public UsersResources(UserRepository userRepository, UsersResourcesService usersResourcesService, CustomUserDetailsService customUserDetailsService, UploadFileService uploadFileService) {
        this.userRepository = userRepository;
        this.usersResourcesService = usersResourcesService;
        this.customUserDetailsService = customUserDetailsService;
        this.uploadFileService = uploadFileService;
    }


    @RequestMapping(value = "/authentication")
    public boolean getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (authentication != null && !(authentication instanceof AnonymousAuthenticationToken));
    }

    @RequestMapping(value = "/logged/details", produces = "application/json")
    public User getLoggedUserDetails(final Authentication authentication) {
        return userRepository.getUserByLogin(authentication.getName());
    }

    @RequestMapping(value = "/user", produces = "application/json")
    public User getUser(@RequestParam("id") Long id) {
        return userRepository.getUserById(id);
    }

    @RequestMapping("/add")
    public String addUser() {
        User user = new User();
        user.setLogin("test");
        user.setPassword("test");
        userRepository.createUser(user);
        return "Create user";
    }

    @RequestMapping("/remove")
    public String removeUser() {
        User user = userRepository.getUserById(5L);
        userRepository.removeUser(user);
        userRepository.removeUser(6L);
        return "all users";
    }

    @RequestMapping("/all")
    public
    @ResponseBody
    List<User> getUsers() {
        return userRepository.getAll();
    }

    @RequestMapping("/friends")
    public
    @ResponseBody
    List<User> getFriendsByUser(@RequestParam(value = "id", required = false) Long userId) {
        if (userId == null) {
            userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
        }
        return userRepository.getFriendsByUser(userId);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @JsonView(Views.Public.class)
    public
    @ResponseBody
    JsonResponseBody registrationProcess(@RequestBody JsonRegisterForm registerForm) {
        JsonResponseBody result = new JsonResponseBody();
        User user = customUserDetailsService.registrationUser(registerForm);
        result.setResult(new ArrayList<>(Arrays.asList(user)));
        return result;
    }

    @RequestMapping(value = "/confirmRegistration", method = RequestMethod.GET)
    public String confirmRegistration(@RequestParam(value = "id") Long userId, @RequestParam(value = "login") String login) {
        customUserDetailsService.activateUser(userId, login);
        return "SUCCESS YOUR ACCOUNT IS ACTIVE";
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public void uploadImage(@RequestParam("file") MultipartFile file, final Authentication authentication) {
        Long userId = ((CustomUserDetails) authentication.getPrincipal()).getUser().getId();
        uploadFileService.uploadImage(userId, file);
    }

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public List<User> getTopUsers(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize, @RequestParam("pointsType") String pointsType){
        return usersResourcesService.getTopUsersByPointsQuantity(pageNo, pageSize, pointsType);
    }

    @RequestMapping(value = "/addFriend", produces = "application/json")
    public void addFriend(@RequestParam("friendId") Long friendId, final Authentication authentication) {
        Long userId = ((CustomUserDetails) authentication.getPrincipal()).getUser().getId();
        userRepository.addFriend(userId, friendId);
    }

    @RequestMapping(value = "/removeFriend", produces = "application/json")
    public void removeFriend(@RequestParam("friendId") Long friendId, final Authentication authentication) {
        Long userId = ((CustomUserDetails) authentication.getPrincipal()).getUser().getId();
        userRepository.removeFriend(userId, friendId);
    }
}
