package com.aghpk.challenger.data.point;

import com.aghpk.challenger.exeption.ApplicationException;
import com.aghpk.challenger.exeption.ErrorType;

public class PointFactory {

    public interface POINT_TYPE {
        String BASIC = "BASIC";
        String STAR = "STAR";
        String MAIN = "MAIN";
    }

    public static Point createPoint(String pointType) {
        switch (pointType) {
            case POINT_TYPE.BASIC:
                return new BasicPoint();
            case POINT_TYPE.MAIN:
                return new MainPoint();
            case POINT_TYPE.STAR:
                return new StarPoint();
        }
        throw new ApplicationException(ErrorType.WRONG_POINT_TYPE, pointType);
    }
}
