package com.aghpk.challenger.api;

import com.aghpk.challenger.dao.UserDAO;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.model.JsonRegisterForm;
import com.aghpk.challenger.model.JsonResponseBody;
import com.aghpk.challenger.model.Views;
import com.aghpk.challenger.service.CustomUserDetailsService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/users")
public class UsersResources {

    private final UserDAO userDAO;
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public UsersResources(UserDAO userDAO, CustomUserDetailsService customUserDetailsService) {
        this.userDAO = userDAO;
        this.customUserDetailsService = customUserDetailsService;
    }

    @RequestMapping("/user")
    public String getUser() {
        User user = userDAO.findUserByLogin("user");
        return user.toString();
    }

    @RequestMapping("/add")
    public String addUser() {
        User user = new User();
        user.setLogin("test");
        user.setPassword("test");
        userDAO.createUser(user);
        return "Create user";
    }

    @RequestMapping("/remove")
    public String removeUser() {
        User user = userDAO.findUserById(5L);
        userDAO.removeUser(user);
        userDAO.removeUser(6L);
        return "all users";
    }

    @RequestMapping("/list")
    public String getUsers() {
        System.out.println(userDAO.getAll().size());
        return "all users";
    }

    @RequestMapping(value = "/authentication")
    public boolean getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (authentication != null && !(authentication instanceof AnonymousAuthenticationToken));
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
}
