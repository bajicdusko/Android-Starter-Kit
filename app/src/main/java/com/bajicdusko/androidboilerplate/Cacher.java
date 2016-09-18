package com.bajicdusko.androidboilerplate;

import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Sep-16.
 */

public class Cacher {

    private final String TYPE = "_type";
    private final String EMPTY_ARRAY = "[]";
    private final String EMPTY_JSON = "{}";

    SharedPreferences sharedPreferences;
    Gson gson;

    public Cacher(Gson gson, SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }

    public <T> void put(String key, T t) {
        sharedPreferences.edit().putString(key, gson.toJson(t)).apply();
        sharedPreferences.edit().putString(generateTypeKey(key), t.getClass().getName()).apply();
    }

    public <T> T get(String key) {
        try {
            Class<T> cacheClass = (Class<T>) Class.forName(sharedPreferences.getString(generateTypeKey(key), "String"));
            String cachedJson = sharedPreferences.getString(key, cacheClass.isArray() ? EMPTY_ARRAY : EMPTY_JSON);
            return gson.fromJson(cachedJson, cacheClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String generateTypeKey(String key) {
        return key + TYPE;
    }
}
