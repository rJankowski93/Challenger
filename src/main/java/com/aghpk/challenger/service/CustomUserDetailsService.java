package com.aghpk.challenger.service;

import com.aghpk.challenger.repository.UserRepository;
import com.aghpk.challenger.repository.UserRoleRepository;
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

import javax.mail.MessagingException;
import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final SendMailSSL sendMailSSL;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, UserRoleRepository userRoleRepository, SendMailSSL sendMailSSL) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.sendMailSSL = sendMailSSL;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("No user present with login: " + login);
        }
        List<String> userRoles = userRoleRepository.findRolesByUserId(user.getId());
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
            user = userRepository.createUser(user);
        } catch (EntityExistsException e) {
            throw new ApplicationException(ErrorType.USER_EXIST, user.getLogin());
        }
        try {
            sendMailSSL.sendConfirmingMail(user);
        } catch (MessagingException e) {
            throw new ApplicationException(ErrorType.ERROR_SEND_EMAIL);
        }
        return user;
    }

    public void activateUser(Long userId, String login) {
        User user = userRepository.findUserById(userId);
        if (!user.getLogin().equals(login)) {
            throw new ApplicationException(ErrorType.WRONG_CONFIRMATION_LINK);
        }
        user.setEnabled(Boolean.TRUE);
        userRepository.flush();
    }
}
