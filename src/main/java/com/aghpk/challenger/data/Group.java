package com.aghpk.challenger.data;

import javax.persistence.*;

@Entity(name = "GROUP")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_GROUP")
    private Long idGroup;

    @Column(name = "NAME")
    private String name;

    @OneToMany
    private UserGroupsMembership userGroupsMembership;
}
