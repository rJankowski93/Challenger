package com.aghpk.challenger.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "USER_GROUPS_MEMBERSHIP")
public class UserGroupsMembership {
    @Id
    @Column(name = "ID_USER")
    private Long idUser;

    @Column
    private Long idGroup;

    @ManyToOne
    private Group group;

    @ManyToOne
    private User user;

}
