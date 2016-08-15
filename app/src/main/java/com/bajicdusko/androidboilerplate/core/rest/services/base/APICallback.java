package com.bajicdusko.androidboilerplate.core.rest.services.base;

import com.bajicdusko.androidboilerplate.core.rest.exception.ApiException;

public interface APICallback<T> {
    void onSuccess(T response);

    void onFailure(ApiException ex);
}
