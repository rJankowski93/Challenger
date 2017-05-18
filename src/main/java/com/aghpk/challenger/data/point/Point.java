package com.aghpk.challenger.data.point;

import com.aghpk.challenger.data.Challenge;
import com.aghpk.challenger.data.User;
import com.aghpk.challenger.data.interfaces.Scoreable;
import com.aghpk.challenger.exeption.ApplicationException;
import com.aghpk.challenger.exeption.ErrorType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Getter
@Setter
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
    @JsonManagedReference("user-point")
    private User user;

    @Column(name = "CHALLENGE_ID", insertable = false, updatable = false)
    private Long challengeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CHALLENGE_ID")
    @JsonManagedReference(value = "challenge-point")
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

    public void setQuantity(Long quantity) {
        if (quantity < 0) {
            throw new ApplicationException(ErrorType.QUANTITY_POINTS_LESS_ZERO);
        }
        this.quantity = quantity;
    }
}
