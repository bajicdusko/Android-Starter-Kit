package com.bajicdusko.androidrxstarterkit.core;

import android.content.SharedPreferences;

import com.bajicdusko.androidrxstarterkit.core.cache.CacheManager;
import com.bajicdusko.androidrxstarterkit.core.rest.ApiFactory;
import com.bajicdusko.androidrxstarterkit.core.rest.ApiModule;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 18-Jul-16.
 */

@Module(includes = {
        ApiModule.class
})
public class CoreModule {

    @Singleton
    @Provides
    public ApiFactory provideApiFactory(CacheManager cacheManager, Gson gson) {
        return new ApiFactory(gson);
    }

    @Singleton
    @Provides
    public CacheManager provideCacheManager(SharedPreferences sharedPreferences, Gson gson) {
        return new CacheManager(sharedPreferences, gson);
    }
}
