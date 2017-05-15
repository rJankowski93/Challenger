package com.aghpk.challenger.service;

import com.aghpk.challenger.dao.PointRepository;
import com.aghpk.challenger.data.Scoreable;
import com.aghpk.challenger.data.point.Point;
import com.aghpk.challenger.data.point.PointFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PointService {

    @Autowired
    PointRepository pointRepository;

    public void changeQuantityPoint(Scoreable object, Long quantity, String pointType) {
        Point point;
        Optional<Point> pointOptional = object.getPoints().stream().filter(p -> p.getType().equals(pointType)).findFirst();
        if (pointOptional.isPresent()) {
            point = pointOptional.get();
            point.changeQuantityPoint(quantity);
        } else {
            point = PointFactory.createPoint(pointType);
            point.setObject(object);
            point.setQuantity(quantity);
        }
        pointRepository.save(point);
    }
}
