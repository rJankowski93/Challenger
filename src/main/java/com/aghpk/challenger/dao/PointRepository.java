package com.aghpk.challenger.dao;

import com.aghpk.challenger.data.point.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
    Point findPointByUserId(Long userId);

    Point findPointByChallengeId(Long challengeId);
}
