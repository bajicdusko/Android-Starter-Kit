package com.bajicdusko.androidstarterkit.di.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import com.bajicdusko.data.Constants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

@Singleton
@Module
public class AndroidModule {
    private final Context context;

    public AndroidModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    @Named(Constants.APPLICATION_CONTEXT)
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(@Named(Constants.APPLICATION_CONTEXT) Context context) {
        return context.getSharedPreferences("skit_pref", Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    public Resources provideResources(@Named(Constants.APPLICATION_CONTEXT) Context context) {
        return context.getResources();
    }
}
