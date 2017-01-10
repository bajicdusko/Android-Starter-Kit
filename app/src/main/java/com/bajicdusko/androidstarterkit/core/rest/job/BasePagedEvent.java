package com.bajicdusko.androidstarterkit.core.rest.job;

import com.bajicdusko.androidstarterkit.core.rest.exception.ApiException;

public class BasePagedEvent extends BaseEvent {

    public static final int NO_PAGE = -1;

    public final int page;

    public BasePagedEvent(ApiException apiException, boolean isInProgress, boolean isCanceled, int page) {
        super(apiException, isInProgress, isCanceled);
        this.page = page;
    }
}
