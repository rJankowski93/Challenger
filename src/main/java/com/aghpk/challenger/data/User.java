package com.aghpk.challenger.data;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER")
    private Long idUser;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ENABLED")
    private boolean enabled;

    @Column(name = "POINTS")
    private Long points;

    @OneToOne
    private UserRole userRole;

    @OneToMany
    private Friendship usersFriends;

    @OneToMany
    private Friendship friendOfUsers;

    @OneToMany
    private Challenge challenge;

    @OneToMany
    private ChallengesUsers challengeUser;

    @OneToMany
    private UserGroupsMembership usersGroupsMembership;
}
