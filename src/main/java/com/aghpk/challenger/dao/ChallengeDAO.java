package com.aghpk.challenger.dao;

import com.aghpk.challenger.data.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeDAO extends JpaRepository<Challenge, Long> {
    //CRUD
    Challenge createChallenge(Challenge challenge);

    Challenge findChallengeById(Long id);

    Challenge save(Challenge challenge);

    void delete(Long id);

    //FIND
    List<Challenge> findAll();

    List<Challenge> findChallengesByName(String name);

    long count();
}
