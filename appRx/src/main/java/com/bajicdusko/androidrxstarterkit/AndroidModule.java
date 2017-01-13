package com.bajicdusko.androidrxstarterkit;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.location.LocationManager;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationManagerCompat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 18-Jul-16.
 */

@Module
public class AndroidModule {

    @Singleton
    @Provides
    public Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Singleton
    @Provides
    public LocationManager provideLocationManager(Context context) {
        return (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    @Singleton
    @Provides
    public Resources provideResources(Context context) {
        return context.getResources();
    }

    @Singleton
    @Provides
    public NotificationManagerCompat provideNotificationManagerCompat(Context context) {
        return NotificationManagerCompat.from(context);
    }
}
