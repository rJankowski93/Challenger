package com.aghpk.challenger.data;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_ROLE")
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private List<Challenge> challenges;

    @ManyToMany
    @JoinTable(
            name="FRIENDSHIP",
            joinColumns = @JoinColumn(name = "ID_USER",referencedColumnName = "ID_USER"),
            inverseJoinColumns = @JoinColumn(name ="ID_USER",referencedColumnName = "ID_FRIEND"))
            private List<User> users;

    @ManyToMany
    @JoinTable(
            name="CHALLENGES_USERS",
            joinColumns = @JoinColumn(name = "ID_USER",referencedColumnName = "ID_USER"),
            inverseJoinColumns = @JoinColumn(name ="ID_CHALLENGE",referencedColumnName = "ID_CHALLENGE"))
    private List<Challenge> challengesUsers ;

    @ManyToMany
    @JoinTable(
            name="USER_GROUPS_MEMBERSHIP",
            joinColumns = @JoinColumn(name = "ID_USER",referencedColumnName = "ID_USER"),
            inverseJoinColumns = @JoinColumn(name ="ID_GROUP",referencedColumnName = "ID_GROUP"))
    private List<Group> groups ;


}
