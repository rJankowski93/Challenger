package com.aghpk.challenger.data;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity(name = "CHALLENGE")
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CHALLENGE")
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

    @Column(name = "ID_CREATOR", insertable = false, updatable = false)
    private Long idCreator;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_CREATOR")
    private User user;

    @ManyToMany(mappedBy = "challengesUsers")
    private List<User> users;
}
