package com.aghpk.challenger.service;

import com.aghpk.challenger.data.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
@ConfigurationProperties(prefix = "mail")
@Getter
@Setter
public class SendMailSSL {

    private String username;
    private String password;
    private String confirmationLink;

    public void sendConfirmingMail(User user) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("challenger.application.aghpk@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
        message.setSubject("Confirmation registration");
        String textMessage = "Dear " + user.getFirstName() + " if you want active your account, you have to click this link:" + "\n\n";
        textMessage = textMessage + confirmationLink + user.getId().toString() + "&login=" + user.getLogin();
        message.setText(textMessage);
        Transport.send(message);
    }

}
