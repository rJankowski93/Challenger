package com.aghpk.challenger.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
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
    String category;

    @Column(name = "POINTS")
    Long points;

    @Column(name = "REWARD_TYPE")
    String rewardType;

    @Column(name = "REWARD_QUANTITY")
    String rewardQunatity;
}
