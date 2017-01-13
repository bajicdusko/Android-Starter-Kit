package com.bajicdusko.androidrxstarterkit.core.rest;

import com.bajicdusko.androidrxstarterkit.core.rest.api.CategoriesApi;
import com.bajicdusko.androidrxstarterkit.core.rest.api.CommentsApi;
import com.bajicdusko.androidrxstarterkit.core.rest.api.PostsApi;
import com.bajicdusko.androidrxstarterkit.core.rest.model.BaseModel;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.lang.annotation.Annotation;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 18-Jul-16.
 */
public class ApiFactory {

    private Gson gson;
    private static Retrofit retrofit;
    Converter<ResponseBody, BaseModel> errorConverter;

    public ApiFactory(Gson gson) {
        this.gson = gson;
    }

    private Retrofit retrofitInstance(boolean force) {
        if (retrofit == null || force) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(getClient())
                    .baseUrl(ApiConstants.API_URL)
                    .build();

            errorConverter = retrofit.responseBodyConverter(BaseModel.class, new Annotation[0]);
        }

        return retrofit;
    }

    public Converter<ResponseBody, BaseModel> getErrorConverter() {
        return errorConverter;
    }

    private OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    public PostsApi createPostsApi() {
        return retrofitInstance(false).create(PostsApi.class);
    }

    public CommentsApi createCommentsApi() {
        return retrofitInstance(false).create(CommentsApi.class);
    }

    public CategoriesApi createCategoriesApi() {
        return retrofitInstance(false).create(CategoriesApi.class);
    }
}
