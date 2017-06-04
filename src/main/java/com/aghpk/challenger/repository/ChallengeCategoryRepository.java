package com.aghpk.challenger.repository;

import com.aghpk.challenger.data.ChallengeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeCategoryRepository extends JpaRepository<ChallengeCategory, Long> {

    List<ChallengeCategory> getAll();

    long count();
}
