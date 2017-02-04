package com.aghpk.challenger.data;


import javax.persistence.*;

@Entity(name = "CHALLENGE")
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CHALLENGE")
    Long id;

    @Column(name = "NAME")
    String name;

    @Column(name = "DESCRIPTION")
    String description;

    @Column(name = "STATUS")
    String status;

    @Column(name = "CATEGORY")
    String catgory;

    @Column(name = "POINTS")
    int points;

    @Column(name = "REWARD_TYPE")
    String rewardType;

    @Column(name="REWARD_QUANTITY")
    String rewardQuantity;

    @Column(name="ID_CREATOR")
    Long idCreator;
}
