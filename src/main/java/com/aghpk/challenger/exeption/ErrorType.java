package com.aghpk.challenger.exeption;

public enum ErrorType {

    USER_EXIST("This user already exists: \"{0}\""),
    DIFFERENT_PASSWORD("Password do not match"),
    WRONG_EMAIL_FORMAT("Wrong format email: \"{0}\"");

    String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
