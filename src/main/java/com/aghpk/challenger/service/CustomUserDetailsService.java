package com.aghpk.challenger.service;

import com.aghpk.challenger.dao.UserDAO;
import com.aghpk.challenger.dao.UserRoleDAO;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.data.UserRole;
import com.aghpk.challenger.exeption.ApplicationException;
import com.aghpk.challenger.exeption.ErrorType;
import com.aghpk.challenger.model.CustomUserDetails;
import com.aghpk.challenger.model.JsonRegisterForm;
import com.aghpk.challenger.tools.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<String> userRoles = userRoleDAO.findRolesByUserId(user.getId());
        return new CustomUserDetails(user, userRoles);
    }

    public User registrationUser(JsonRegisterForm registerForm) {
        if (!registerForm.getPassword().equals(registerForm.getMatchingPassword())) {
            throw new ApplicationException(ErrorType.DIFFERENT_PASSWORD);
        }
        if (!StringUtil.validateEmail(registerForm.getEmail())) {
            throw new ApplicationException(ErrorType.WRONG_EMAIL_FORMAT, registerForm.getEmail());
        }
        User user = new User(registerForm);
        user.setRoles(new ArrayList<>(Arrays.asList(new UserRole(UserRole.ROLE.USER))));
        try {
            user = userDAO.createUser(user);
        } catch (EntityExistsException e) {
            throw new ApplicationException(ErrorType.USER_EXIST, user.getLogin());
        }
        //TODO send confirmation email
        return user;
    }
}
