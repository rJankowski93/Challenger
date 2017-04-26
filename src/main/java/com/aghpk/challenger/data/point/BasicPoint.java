package com.aghpk.challenger.data.point;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue("BASIC")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BasicPoint extends Point {

    public BasicPoint() {
        setType(PointFactory.POINT_TYPE.BASIC);
    }
}
