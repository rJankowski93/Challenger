package com.aghpk.challenger.tools;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.regex.Matcher;

public class StringUtils {

    public static String replace(String message, Object[] params) {
        if (params != null && message != null) {
            for (int i = 0; i < params.length; i++) {
                message = message.replaceAll("\\{" + i + "\\}", ((params.length > i && params[i] != null)
                        ? Matcher.quoteReplacement(params[i].toString()) : "null"));
            }
        }
        return message;
    }

    public static boolean validateEmail(String email) {
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
        } catch (AddressException e) {
            return false;
        }
        return true;
    }
}