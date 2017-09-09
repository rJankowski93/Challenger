package com.aghpk.challenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookLink;
import org.springframework.stereotype.Service;

@Service
public class FacebookService {

    @Autowired
    private Facebook facebook;


    public void shareChallenge(Long challengeId) {
        //TODO generate link to challenge details
        String message = "New challenge!";
        FacebookLink link = new FacebookLink("www.onet.pl",
                "Spring Social",
                "The Spring Social Project",
                "Spring Social is an extension to Spring to enable applications to connect with service providers.");
        facebook.feedOperations().postLink(message, link);
    }
}
