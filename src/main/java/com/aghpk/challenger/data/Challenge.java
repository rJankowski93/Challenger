package com.aghpk.challenger.data;


import javax.persistence.*;

@Entity(name = "CHALLENGE")
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CHALLENGE")
    private Long idChallenge;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CATEGORY")
    private String catgory;

    @Column(name = "POINTS")
    private int points;

    @Column(name = "REWARD_TYPE")
    private String rewardType;

    @Column(name = "REWARD_QUANTITY")
    private String rewardQuantity;

    @Column(name = "ID_CREATOR")
    private Long idCreator;

    @OneToMany
    private ChallengesUsers challengesUsers;

    @ManyToOne
    private User user;

}
