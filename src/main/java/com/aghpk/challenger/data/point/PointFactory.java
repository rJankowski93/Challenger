package com.aghpk.challenger.data.point;

import com.aghpk.challenger.exeption.ApplicationException;
import com.aghpk.challenger.exeption.ErrorType;

public class PointFactory {

    public interface PointType {
        String BASIC = "BASIC";
        String STAR = "STAR";
        String MAIN = "MAIN";
    }

    public static Point createPoint(String pointType) {
        switch (pointType) {
            case PointType.BASIC:
                return new BasicPoint();
            case PointType.MAIN:
                return new MainPoint();
            case PointType.STAR:
                return new StarPoint();
        }
        throw new ApplicationException(ErrorType.WRONG_POINT_TYPE, pointType);
    }
}
