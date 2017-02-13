package com.aghpk.challenger.data;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "CHALLENGE")
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHALLENGE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CATEGORY")
    private String catgory;

    @Column(name = "POINTS")
    private Long points;

    @Column(name = "REWARD_TYPE")
    private String rewardType;

    @Column(name = "REWARD_QUANTITY")
    private String rewardQuantity;

    @Column(name = "CREATOR_ID", insertable = false, updatable = false)
    private Long idCreator;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CREATOR_ID")
    private User user;

    @ManyToMany(mappedBy = "challengesUsers")
    private List<User> users;
}
