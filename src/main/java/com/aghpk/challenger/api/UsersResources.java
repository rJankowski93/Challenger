package com.aghpk.challenger.api;

import com.aghpk.challenger.dao.UserRepository;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.model.CustomUserDetails;
import com.aghpk.challenger.model.JsonRegisterForm;
import com.aghpk.challenger.model.JsonResponseBody;
import com.aghpk.challenger.model.Views;
import com.aghpk.challenger.service.CustomUserDetailsService;
import com.aghpk.challenger.service.UploadFileService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/users")
public class UsersResources {

    private final UserRepository userRepository;
    private final CustomUserDetailsService customUserDetailsService;
    private final UploadFileService uploadFileService;

    @Autowired
    public UsersResources(UserRepository userRepository, CustomUserDetailsService customUserDetailsService, UploadFileService uploadFileService) {
        this.userRepository = userRepository;
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
        return userRepository.findUserByLogin(authentication.getName());
    }

    @RequestMapping("/user")
    public String getUser() {
        User user = userRepository.findUserByLogin("user");
        return user.toString();
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
        User user = userRepository.findUserById(5L);
        userRepository.removeUser(user);
        userRepository.removeUser(6L);
        return "all users";
    }

    @RequestMapping("/list")
    public String getUsers() {
        System.out.println(userRepository.getAll().size());
        return "all users";
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
    public String uploadImage( @RequestParam("file") MultipartFile file, final Authentication authentication) {
        Long userId = ((CustomUserDetails)authentication.getPrincipal()).getUser().getId();
        uploadFileService.uploadImage(userId, file);
        return "SUCCESS UPLOAD YOUR AVATAR";
    }
}
