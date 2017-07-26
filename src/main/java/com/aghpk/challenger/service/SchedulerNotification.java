package com.aghpk.challenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SchedulerNotification {

    @Autowired
    SenderNotification senderNotification;

//    @Scheduled(fixedDelay = 1000)
//    public void sendCounterUpdate() throws IOException {
//        senderNotification.sendMessage();
//    }
}
