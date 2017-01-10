package com.bajicdusko.androidstarterkit.core.rest.services.base;

import com.bajicdusko.androidstarterkit.core.rest.exception.ApiException;

public interface APICallback<T> {
    void onSuccess(T response);

    void onFailure(ApiException ex);
}
