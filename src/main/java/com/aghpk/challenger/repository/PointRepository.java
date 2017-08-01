package com.aghpk.challenger.repository;

import com.aghpk.challenger.data.point.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
    Point getPointByUserId(Long userId);

    Point getPointByChallengeId(Long challengeId);
}
