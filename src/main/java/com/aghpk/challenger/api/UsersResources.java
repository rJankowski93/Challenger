package com.aghpk.challenger.api;

import com.aghpk.challenger.dao.UserDAO;
import com.aghpk.challenger.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersResources {

    @Autowired
    UserDAO userDAO;

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
}
