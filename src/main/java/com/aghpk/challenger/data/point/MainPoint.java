package com.aghpk.challenger.data.point;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue("MAIN")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class MainPoint extends Point{

    public MainPoint() {
        setType(PointFactory.PointType.MAIN);
    }
}
