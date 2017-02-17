package com.aghpk.challenger.api;

import com.aghpk.challenger.dao.UserDAO;
import com.aghpk.challenger.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersResources {

    @Autowired
    UserDAO userDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/user")
    public String getUser() {
        User user = userDAO.findUserByLogin("user");
        return user.toString();
    }

    @RequestMapping("/add")
    public String addUser() {
        return "Create user";
    }

    @RequestMapping("/list")
    public String getUsers() {
        return "One challenger";
    }
}
