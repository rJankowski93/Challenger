package com.aghpk.challenger.service;

import com.aghpk.challenger.data.Notification;
import com.aghpk.challenger.exeption.ApplicationException;
import com.aghpk.challenger.exeption.ErrorType;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Component
public class SenderNotification extends TextWebSocketHandler {

    Set<WebSocketSession> webSocketSession = new HashSet();

//    @OnMessage
//    public void onMessage(String m, Session s) throws IOException {
//        for (Session session : s.getOpenSessions()) {
//            session.getBasicRemote().sendText(m);
//        }
//    }

    public void sendMessage(Notification notification) {
        Iterator<WebSocketSession> iterator = webSocketSession.iterator();

        while (iterator.hasNext()) {
            WebSocketSession session = iterator.next();
            String path = session.getUri().getPath();
            String userId = path.substring(path.lastIndexOf("/") + 1);
            if (notification.getSubject().getId() == Long.valueOf(userId) && session.isOpen()) {
                try {
                    session.sendMessage(new TextMessage("{\"value\": \"" + notification.getMessage() + "\"}"));
                } catch (IOException e) {
                    new ApplicationException(ErrorType.WRONG_CONNECTION);
                }
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        webSocketSession.add(session);
    }

//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message)
//            throws Exception {
//        if ("CLOSE".equalsIgnoreCase(message.getPayload())) {
//            session.close();
//        } else {
//            System.out.println("Received:" + message.getPayload());
//        }
//    }
}
