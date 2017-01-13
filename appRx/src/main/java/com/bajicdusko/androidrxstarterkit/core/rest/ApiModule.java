package com.bajicdusko.androidrxstarterkit.core.rest;

import com.bajicdusko.androidrxstarterkit.core.rest.api.CategoriesApi;
import com.bajicdusko.androidrxstarterkit.core.rest.api.CommentsApi;
import com.bajicdusko.androidrxstarterkit.core.rest.api.PostsApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 18-Jul-16.
 */

@Module
public class ApiModule {

    @Singleton
    @Provides
    public PostsApi providePostsApi(ApiFactory apiFactory) {
        return apiFactory.createPostsApi();
    }

    @Singleton
    @Provides
    public CommentsApi provideCommentsApi(ApiFactory apiFactory) {
        return apiFactory.createCommentsApi();
    }

    @Singleton
    @Provides
    public CategoriesApi provideCategoriesApi(ApiFactory apiFactory) {
        return apiFactory.createCategoriesApi();
    }
}
