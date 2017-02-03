package com.aghpk.challenger.service;

import com.aghpk.challenger.dao.UserDAO;
import com.aghpk.challenger.dao.UserRolesDAO;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final UserDAO userDAO;
    private final UserRolesDAO userRolesDAO;

    @Autowired
    public CustomUserDetailsService(UserDAO userDAO, UserRolesDAO userRolesDAO) {
        this.userDAO = userDAO;
        this.userRolesDAO = userRolesDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDAO.findUserByFirstname(username);

        if(user==null){
            throw new UsernameNotFoundException("No user present with username: "+username);
        }

//        List<String> userRoles=userRolesDAO.findRoleByIdUser(user.getId());
//        //TODO use method above
        List<String> userRoles=new ArrayList<>();
        userRoles.add("USER");
        userRoles.add("ADMIN");
        return new CustomUserDetails(user, userRoles);
    }
}
