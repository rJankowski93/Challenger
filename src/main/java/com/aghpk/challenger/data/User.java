package com.aghpk.challenger.data;


import com.aghpk.challenger.data.interfaces.Scoreable;
import com.aghpk.challenger.data.point.Point;
import com.aghpk.challenger.model.JsonRegisterForm;
import com.aghpk.challenger.model.Views;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "USER")
@AttributeOverrides({
        @AttributeOverride(name = "auditCD", column = @Column(name = "AUDIT_CD", updatable = false)),
        @AttributeOverride(name = "auditMD", column = @Column(name = "AUDIT_MD")),
        @AttributeOverride(name = "auditRD", column = @Column(name = "AUDIT_RD")),
})
public class User extends Audit implements Serializable, Scoreable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "LOGIN")
    @JsonView(Views.Public.class)
    private String login;

    @Column(name = "FIRSTNAME")
    @JsonView(Views.Public.class)
    private String firstName;

    @Column(name = "LASTNAME")
    @JsonView(Views.Public.class)
    private String lastname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    @JsonView(Views.Public.class)
    private String email;

    @Column(name = "ENABLED")
    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @JsonManagedReference
    private List<UserRole> roles;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @JsonManagedReference
    private Set<Point> points;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CREATOR_ID", referencedColumnName = "USER_ID")
    @JsonBackReference
    private List<Challenge> challenges;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "FRIENDSHIP",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FRIEND_ID", referencedColumnName = "USER_ID"))
    @JsonManagedReference
    private List<User> friends;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CHALLENGES_USERS",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHALLENGE_ID", referencedColumnName = "CHALLENGE_ID"))
    @JsonBackReference
    private List<Challenge> challengesUsers;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_GROUPS_MEMBERSHIP",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID"))
    @JsonManagedReference
    private List<Group> groups;


    public User(JsonRegisterForm jsonRegisterForm) {
        this.login = jsonRegisterForm.getLogin();
        this.firstName = jsonRegisterForm.getFirstname();
        this.lastname = jsonRegisterForm.getLastname();
        this.password = jsonRegisterForm.getPassword();
        this.email = jsonRegisterForm.getEmail();
    }

    @PrePersist
    public void onPrePersist() {
        setAuditCD(new Date());
    }

    @PreUpdate
    public void onPreUpdate() {
        setAuditMD(new Date());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<Challenge> getChallengesUsers() {
        return challengesUsers;
    }

    public void setChallengesUsers(List<Challenge> challengesUsers) {
        this.challengesUsers = challengesUsers;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return ("Login: " + login + " Password: " + password);
    }
}
