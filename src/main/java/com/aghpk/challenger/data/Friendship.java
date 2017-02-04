package com.aghpk.challenger.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "FRIENDSHIP")
public class Friendship {
    @Id
    @Column(name = "ID_USER")
    private Long idUser;

    @Column(name = "ID_FRIEND")
    private Long idFriend;

    @ManyToOne
    private User user;

    @ManyToOne
    private User friend;
}
