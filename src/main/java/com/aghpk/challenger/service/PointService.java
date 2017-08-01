package com.aghpk.challenger.service;

import com.aghpk.challenger.data.interfaces.Scoreable;
import com.aghpk.challenger.data.point.Point;
import com.aghpk.challenger.data.point.PointFactory;
import com.aghpk.challenger.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService {

    private final PointRepository pointRepository;

    @Autowired
    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public void changeQuantityPoint(Scoreable object, Long quantity, String pointType) {
        Point point = object.getPoints().stream()
                .filter(p -> p.getType().equals(pointType))
                .findFirst()
                .orElse(PointFactory.createPoint(pointType));
        if (point.getQuantity() != null) {
            point.changeQuantityPoint(quantity);
        } else {
            point.setObject(object);
            point.setQuantity(quantity);
        }
        pointRepository.save(point);
    }
}
