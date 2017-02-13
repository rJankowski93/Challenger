package com.aghpk.challenger.service;

import com.aghpk.challenger.dao.UserDAO;
import com.aghpk.challenger.dao.UserRoleDAO;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDAO userDAO;
    private final UserRoleDAO userRoleDAO;

    @Autowired
    public CustomUserDetailsService(UserDAO userDAO, UserRoleDAO userRoleDAO) {
        this.userDAO = userDAO;
        this.userRoleDAO = userRoleDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDAO.findUserByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("No user present with login: " + login);
        }
        List<String> userRoles = userRoleDAO.findRolesByIdUser(user.getId());
        return new CustomUserDetails(user, userRoles);
    }
}
