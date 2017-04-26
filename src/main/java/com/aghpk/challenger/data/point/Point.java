package com.aghpk.challenger.data.point;

import com.aghpk.challenger.data.Challenge;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.data.interfaces.Scoreable;
import com.aghpk.challenger.exeption.ApplicationException;
import com.aghpk.challenger.exeption.ErrorType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Entity
@Table(name = "POINT")
@DiscriminatorColumn(name = "PointType")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POINT_ID")
    private Long id;

    @Column(name = "QUANTITY")
    private Long quantity;

    @Column(name = "PointType", insertable = false, updatable = false)
    private String type;

    @Column(name = "USER_ID", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    @Column(name = "CHALLENGE_ID", insertable = false, updatable = false)
    private Long challengeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CHALLENGE_ID")
    @JsonBackReference
    private Challenge challenge;

    public void changeQuantityPoint(Long quantityPoints) {
        if (quantityPoints < 0 && quantityPoints > this.quantity) {
            throw new ApplicationException(ErrorType.NOT_ENOUGH_POINTS);
        }
        this.quantity = this.quantity + quantityPoints;
    }

    public void setObject(Scoreable object) {
        if (object instanceof User) {
            this.user = (User) object;
        } else {
            this.challenge = (Challenge) object;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        if (quantity < 0) {
            throw new ApplicationException(ErrorType.QUANTITY_POINTS_LESS_ZERO);
        }
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Long challengeId) {
        this.challengeId = challengeId;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}
