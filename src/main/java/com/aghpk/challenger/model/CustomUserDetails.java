package com.aghpk.challenger.model;

import com.aghpk.challenger.data.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails extends User implements UserDetails {

    private static final long serialVersionUID=1L;
    private List<String> userRoles;

    public CustomUserDetails(User user, List<String> userRoles) {
        super(user);
        this.userRoles = userRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<String> userRolesTemporary=new ArrayList<>();
//        userRolesTemporary.add("USER");
//        userRolesTemporary.add("ADMIN");

        String roles= StringUtils.collectionToCommaDelimitedString(userRoles);
        //TODO add real data as above
//        String roles=StringUtils.collectionToCommaDelimitedString(userRolesTemporary);

        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        //TODO should we change it to firstname+lastname?
        return super.getFirstname();
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
