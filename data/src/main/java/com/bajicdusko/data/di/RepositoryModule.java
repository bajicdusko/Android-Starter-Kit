package com.bajicdusko.data.di;

import android.content.SharedPreferences;

import com.bajicdusko.data.repository.CacheRepository;
import com.bajicdusko.data.repository.impl.CacheRepositoryImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

@Module
public class RepositoryModule {

    @Provides
    public CacheRepository provideCacheRepository(SharedPreferences sharedPreferences) {
        return new CacheRepositoryImpl(sharedPreferences);
    }
}
