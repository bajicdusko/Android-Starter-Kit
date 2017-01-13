package com.bajicdusko.androidrxstarterkit.core.rest.exception;

public class ApiException extends Exception {

    public static final int NO_ERROR_CODE = -1;
    private int errorCode = NO_ERROR_CODE;

    public ApiException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable t) {
        super(t);
    }

    public int getErrorCode() {
        return errorCode;
    }
}
