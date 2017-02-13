package com.aghpk.challenger.model;

import com.aghpk.challenger.data.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;
    private List<String> userRoles;
    private User user;

    public CustomUserDetails(User user, List<String> userRoles) {
        this.user=user;
        this.userRoles = userRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        //TODO implement this method
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //TODO implement this method
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //TODO implement this method
        return true;
    }

    @Override
    public boolean isEnabled() {
        //TODO implement this method
        return true;
    }
}
