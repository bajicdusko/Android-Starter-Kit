package com.bajicdusko.androidboilerplate.core.rest.job;

import com.bajicdusko.androidboilerplate.core.rest.exception.ApiException;

public class BaseEvent {

    private final String EMPTY_STRING = "";
    protected final ApiException apiException;
    protected final boolean isInProgress;
    protected final boolean isCanceled;

    public BaseEvent(ApiException apiException, boolean isInProgress, boolean isCanceled) {
        this.apiException = apiException;
        this.isInProgress = isInProgress;
        this.isCanceled = isCanceled;
    }

    public boolean isInProgress() {
        return isInProgress;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public boolean hasError() {
        return apiException != null;
    }

    public ApiException getException() {
        return apiException;
    }

    public String getErrorMessage() {
        return apiException != null ? apiException.getMessage() : EMPTY_STRING;
    }
}
