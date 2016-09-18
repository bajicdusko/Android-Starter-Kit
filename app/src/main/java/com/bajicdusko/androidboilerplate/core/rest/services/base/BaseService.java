package com.bajicdusko.androidboilerplate.core.rest.services.base;

import android.content.Context;
import android.text.TextUtils;

import com.bajicdusko.androidboilerplate.core.cache.CacheManager;
import com.bajicdusko.androidboilerplate.core.rest.ApiFactory;

import javax.inject.Inject;

public class BaseService<T> {

    @Inject
    protected CacheManager cacheManager;
    @Inject
    protected Context context;
    @Inject
    protected ApiFactory apiFactory;

    public BaseService() {
    }

    protected CallbackInterceptor convertCallback(APICallback<T> apiCallback) {
        return new CallbackInterceptor(apiCallback, apiFactory, context);
    }

    protected boolean allMandatoryFieldsAreSet(Object... args) {
        for (Object arg : args) {
            if (arg instanceof String && TextUtils.isEmpty(String.valueOf(arg))) {
                return false;
            } else if (arg instanceof Integer && (int) arg == 0) {
                return false;
            }
        }

        return true;
    }
}
