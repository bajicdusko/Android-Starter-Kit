package com.bajicdusko.data.di;

import com.bajicdusko.androidstarterkit.repository.CacheRepository;
import com.bajicdusko.data.api.AnnotationExclusionStrategy;
import com.bajicdusko.data.api.ApiFactory;
import com.bajicdusko.data.api.questions.QuestionsApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.joda.time.DateTime;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

@Module
public class ApiModule {

    @Provides
    public Gson provideGson() {
        return new GsonBuilder()
                .registerTypeAdapter(Boolean.class, TypeAdapterUtil.getBooleanAdapter())
                .registerTypeAdapter(boolean.class, TypeAdapterUtil.getBooleanAdapter())
                .registerTypeAdapter(DateTime.class, TypeAdapterUtil.getDateTimeAdapter())
                .addSerializationExclusionStrategy(new AnnotationExclusionStrategy())
                .create();
    }

    @Provides
    public ApiFactory provideApiFactory(Gson gson, CacheRepository cacheRepository) {
        return new ApiFactory(gson, cacheRepository);
    }

    @Provides
    public QuestionsApi provideQuestionApi(ApiFactory apiFactory) {
        return apiFactory.createQuestionApi();
    }
}
