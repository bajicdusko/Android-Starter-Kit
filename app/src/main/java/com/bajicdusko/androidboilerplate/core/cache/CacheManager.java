package com.bajicdusko.androidboilerplate.core.cache;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Inject;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class CacheManager {

    SharedPreferences sharedPreferences;
    Gson gson;

    @Inject
    public CacheManager(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }
}
