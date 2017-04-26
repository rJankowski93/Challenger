package com.aghpk.challenger.data.point;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue("STAR")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class StarPoint extends Point {

    public StarPoint() {
        setType(PointFactory.PointType.STAR);
    }

}
