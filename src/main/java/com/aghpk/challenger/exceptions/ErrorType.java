package com.aghpk.challenger.exceptions;

public enum ErrorType {

    USER_EXIST("This user already exists: \"{0}\""),
    FRIEND_EXIST("You has already friend:  \"{0}\""),
    DIFFERENT_PASSWORD("Password do not match"),
    WRONG_EMAIL_FORMAT("Wrong format email: \"{0}\""),
    ERROR_SEND_EMAIL("Sending email failed, please enter a different email"),
    WRONG_CONFIRMATION_LINK("Wrong confirmation link"),
    EMPTY_FILE("File: \"{0}\" is empty"),
    FAILED_UPLOAD("Failed to upload"),
    WRONG_TYPE_FILE("FIle: \"{0}\" has wrong type"),
    WRONG_POINT_TYPE("The point type: \"{0}\" is not recognized."),
    NOT_ENOUGH_POINTS("The quantity of points is not enough"),
    QUANTITY_POINTS_LESS_ZERO("The quantity of points cann't be less than zero"),
    WRONG_CONNECTION("Any problem with connection"),
    WRONG_STATUS_CHALLENGE("The challenge has wrong status: \"{0}\"");

    String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
