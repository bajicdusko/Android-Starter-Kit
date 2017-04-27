package com.bajicdusko.data.api;

import android.text.TextUtils;
import android.util.Base64;

import com.bajicdusko.androidstarterkit.repository.CacheRepository;
import com.bajicdusko.data.BuildConfig;
import com.bajicdusko.data.RxJava2ErrorHandlerCallAdapterFactory;
import com.bajicdusko.data.api.questions.QuestionsApi;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

public class ApiFactory {
    private Retrofit retrofit;
    private Retrofit geocodeRetrofit;
    private CacheRepository cacheRepository;

    public ApiFactory(Gson gson, CacheRepository cacheRepository) {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addCallAdapterFactory(new RxJava2ErrorHandlerCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getClient())
                .build();

        this.cacheRepository = cacheRepository;
    }

    private OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
                .addInterceptor(chain -> {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("Content-Type", "application/json;charset=utf-8")
                            .addHeader("Accept", "application/json")
                            .build();

                    if (!TextUtils.isEmpty(cacheRepository.getUsername()) && !TextUtils.isEmpty(cacheRepository.getPassword())) {
                        String credentialsConcat = cacheRepository.getUsername() + ":" + cacheRepository.getPassword();
                        String base64Credentials = Base64.encodeToString(credentialsConcat.getBytes(), Base64.URL_SAFE);

                        request = request.newBuilder()
                                .addHeader("Authorization", "Basic " + base64Credentials.replace("\n", ""))
                                .build();
                    }

                    return chain.proceed(request);
                }).build();
    }

    public QuestionsApi createQuestionApi() {
        return retrofit.create(QuestionsApi.class);
    }
}
