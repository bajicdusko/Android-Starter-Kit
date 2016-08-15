package com.bajicdusko.androidboilerplate.core.rest;

import com.bajicdusko.androidboilerplate.core.rest.api.PostsApi;

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
}
