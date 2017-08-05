package com.aghpk.challenger.exeption;

import com.aghpk.challenger.tools.StringUtils;

public class ApplicationException extends RuntimeException {

    private ErrorType errorCode;

    private String message;

    public ApplicationException(ErrorType errorCode, Object... msgParams) {
        super();
        this.errorCode = errorCode;
        this.message = StringUtils.replace(errorCode.getMessage(), msgParams);
    }

    public ErrorType getErrorCode() {
        return errorCode;
    }

    public String getCodeMessage() {
        return "[" + getErrorCode() + "] " + message;
    }

    public String getMessage() {
        return message;
    }
}