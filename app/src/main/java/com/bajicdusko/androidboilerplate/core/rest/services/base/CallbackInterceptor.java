package com.bajicdusko.androidboilerplate.core.rest.services.base;

import com.bajicdusko.androidboilerplate.core.rest.ApiFactory;
import com.bajicdusko.androidboilerplate.core.rest.exception.ApiException;
import com.bajicdusko.androidboilerplate.core.rest.model.BaseModel;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallbackInterceptor<T> implements Callback<T> {

    APICallback<T> apiCallback;
    ApiFactory apiFactory;

    public CallbackInterceptor(APICallback<T> apiCallback, ApiFactory apiFactory) {
        this.apiCallback = apiCallback;
        this.apiFactory = apiFactory;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (apiCallback != null) {
            if (!response.isSuccessful()) {
                try {
                    BaseModel errorModel = apiFactory.getErrorConverter().convert(response.errorBody());
                    apiCallback.onFailure(new ApiException(errorModel.getDescription(), errorModel.getCode()));
                } catch (IOException ex) {
                    apiCallback.onFailure(new ApiException(response.raw().message()));
                }

            } else {
                apiCallback.onSuccess(response.body());
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (apiCallback != null) {
            apiCallback.onFailure(new ApiException(t));
        }
    }
}
