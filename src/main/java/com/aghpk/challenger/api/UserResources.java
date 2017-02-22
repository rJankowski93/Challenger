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
@RequestMapping("/api/user")
public class UserResources {

    private final UserDAO userDAO;

    @Autowired
    public UserResources(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(value = "/authentication")
    public boolean getAuthentication() {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        return (authentication!=null && !(authentication instanceof  AnonymousAuthenticationToken));
    }

    @RequestMapping(value="/logged/details", produces = "application/json")
    public User getLoggedUserDetails(final Authentication authentication){
        return userDAO.findUserByLogin(authentication.getName());
    }
}
