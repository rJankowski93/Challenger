package com.aghpk.challenger.exeption;

import com.aghpk.challenger.tools.StringUtil;

public class ApplicationException extends RuntimeException {

    private ErrorType errorCode;

    private String message;

    public ApplicationException(ErrorType errorCode, Object... msgParams) {
        super();
        this.errorCode = errorCode;
        this.message = StringUtil.replace(errorCode.getMessage(), msgParams);
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