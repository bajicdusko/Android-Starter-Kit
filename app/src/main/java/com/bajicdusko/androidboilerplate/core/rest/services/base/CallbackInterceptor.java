package com.bajicdusko.androidboilerplate.core.rest.services.base;

import android.content.Context;

import com.bajicdusko.androidboilerplate.core.rest.ApiFactory;
import com.bajicdusko.androidboilerplate.core.rest.exception.ApiException;
import com.bajicdusko.androidboilerplate.core.rest.exception.NoConnectionException;
import com.bajicdusko.androidboilerplate.core.rest.model.BaseModel;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallbackInterceptor<T> implements Callback<T> {

    APICallback<T> apiCallback;
    ApiFactory apiFactory;
    Context context;

    public CallbackInterceptor(APICallback<T> apiCallback, ApiFactory apiFactory, Context context) {
        this.apiCallback = apiCallback;
        this.apiFactory = apiFactory;
        this.context = context;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (apiCallback != null) {
            if (!response.isSuccessful()) {
                try {
                    BaseModel errorModel = apiFactory.getErrorConverter().convert(response.errorBody());
                    if (errorModel.getDescription().contains("UnknownHostException")) {
                        apiCallback.onFailure(new NoConnectionException(context));
                    } else {
                        apiCallback.onFailure(new ApiException(errorModel.getDescription(), errorModel.getCode()));
                    }
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
            if (t instanceof UnknownHostException || t instanceof ConnectException) {
                apiCallback.onFailure(new NoConnectionException(context));
            } else {
                apiCallback.onFailure(new ApiException(t));
            }
        }
    }
}
