package com.aghpk.challenger.service;

import com.aghpk.challenger.data.Challenge;
import com.aghpk.challenger.data.ChallengeCategory;
import com.aghpk.challenger.data.Notification;
import com.aghpk.challenger.exeption.ApplicationException;
import com.aghpk.challenger.exeption.ErrorType;
import com.aghpk.challenger.repository.ChallengeCategoryRepository;
import com.aghpk.challenger.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService {

    private final ChallengeRepository challengeRepository;

    private final UserService userService;

    private final ChallengeCategoryRepository challengeCategoryRepository;

    private final NotificationService notificationService;

    @Autowired
    public ChallengeService(ChallengeRepository challengeRepository, UserService userService, ChallengeCategoryRepository challengeCategoryRepository, NotificationService notificationService) {
        this.challengeRepository = challengeRepository;
        this.userService = userService;
        this.challengeCategoryRepository = challengeCategoryRepository;
        this.notificationService = notificationService;
    }

    public List<Challenge> getChallenges() {
        return challengeRepository.getAll();
    }

    public Challenge getChallenge(Long challengeId) {
        return challengeRepository.getChallengeById(challengeId);
    }

    public void addChallenge(Challenge challenge) {
        challengeRepository.save(challenge);
    }

    public List<Challenge> getChallengesByUser(Long userId) {
        return challengeRepository.getChallengesByUser(userId != null ? userId : userService.getCurrentUser().getId());
    }

    public List<ChallengeCategory> getCategories() {
        return challengeCategoryRepository.getAll();
    }

    public void acceptChallenge(Long notificationId, Long challengeId) {
        Challenge challenge = challengeRepository.getChallengeById(challengeId);
        if (!challenge.getStatus().equals(Challenge.Status.WAITING_FOR_APPROVAL)) {
            throw new ApplicationException(ErrorType.WRONG_STATUS_CHALLENGE, challenge.getStatus());
        }
        challenge.setStatus(Challenge.Status.IN_PROGRESS);
        notificationService.changeStatus(notificationId, Notification.Status.INACTIVE);
        //TODO zmienic z listy na cos innego jak juz podejmiemy decyzje jak maja dzialac challenge
        // moglby np byc tutaj if ze jezeli subject jest pusty tzn ze challenge jest dla wsyztskich i wtedy ten co pierwszy ten wygrywa
        //a jezlei subject nie zgadza sie z aktualnym userem tzn ze blad bo to nie jego wyzwanie
        notificationService.sendNotification(Notification.Type.CHALLENGE_ACCEPTANCE, userService.getCurrentUser(), challenge.getCreator(), challenge);
    }

    public void rejectChallenge(Long notificationId, Long challengeId) {
        Challenge challenge = challengeRepository.getChallengeById(challengeId);
        if (!challenge.getStatus().equals(Challenge.Status.WAITING_FOR_APPROVAL)) {
            throw new ApplicationException(ErrorType.WRONG_STATUS_CHALLENGE, challenge.getStatus());
        }
        notificationService.changeStatus(notificationId, Notification.Status.INACTIVE);
        notificationService.sendNotification(Notification.Type.CHALLENGE_REFUSE, userService.getCurrentUser(), challenge.getCreator(), challenge);
    }


}
