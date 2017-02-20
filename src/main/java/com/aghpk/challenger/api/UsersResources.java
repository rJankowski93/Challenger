package com.aghpk.challenger.api;

import com.aghpk.challenger.dao.UserDAO;
import com.aghpk.challenger.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersResources {

    private final UserDAO userDAO;

    @Autowired
    public UsersResources(UserDAO userDAO) {
        this.userDAO = userDAO;
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
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return (authentication!=null && !(authentication instanceof AnonymousAuthenticationToken));
    }
}
