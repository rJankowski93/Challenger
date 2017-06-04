package com.aghpk.challenger.repository;

import com.aghpk.challenger.data.Challenge;
import com.aghpk.challenger.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    Challenge findChallengeById(Long id);

    User createChallenge(Challenge challenge);

    void removeChallenge(Challenge challenge);

    void removeChallenge(Long id);

    List<Challenge> getAll();

    List<Challenge> getChallengesByUser(Long userId);

    List<Challenge> findChallengesByName(String name);

    long count();

}
