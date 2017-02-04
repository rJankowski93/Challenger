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
    String category;

    @Column(name = "POINTS")
    Long points;

    @Column(name = "REWARD_TYPE")
    String rewardType;

    @Column(name = "REWARD_QUANTITY")
    String rewardQunatity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public String getRewardQunatity() {
        return rewardQunatity;
    }

    public void setRewardQunatity(String rewardQunatity) {
        this.rewardQunatity = rewardQunatity;
    }
}
