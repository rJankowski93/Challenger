package com.aghpk.challenger.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "CHALLENGES_USERS")
public class ChallengesUsers {
    @Id
    @Column(name = "ID_CHALLENGE")
    Long idChallenge;

    @Column(name = "ID_USER")
    Long idUser;

    @ManyToOne
    private User user;

    @ManyToOne
    private Challenge challenge;


}
