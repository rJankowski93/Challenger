package com.aghpk.challenger.exeption;

public enum ErrorType {

    USER_EXIST("This user already exists: \"{0}\""),
    DIFFERENT_PASSWORD("Password do not match"),
    WRONG_EMAIL_FORMAT("Wrong format email: \"{0}\""),
    ERROR_SEND_EMAIL("Sending email failed, please enter a different email"),
    WRONG_CONFIRMATION_LINK("Wrong confirmation link"),
    EMPTY_FILE("File: \"{0}\" is empty"),
    FAILED_UPLOAD("Failed to upload"),
    WRONG_TYPE_FILE("FIle: \"{0}\" has wrong type");

    String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
