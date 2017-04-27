package com.bajicdusko.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.bajicdusko.androidstarterkit.repository.CacheRepository;
import com.bajicdusko.data.repository.CacheRepositoryImpl;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 20.04.17.
 */

@RunWith(RobolectricTestRunner.class)
public class CacheTests {

    @Test
    public void shouldBeLoggedIn() {

        SharedPreferences testPref = RuntimeEnvironment.application.getSharedPreferences("test_pref", Context.MODE_PRIVATE);
        CacheRepository cacheRepository = new CacheRepositoryImpl(testPref);
        cacheRepository.setUsername("username");
        cacheRepository.setPassword("password");

        Assert.assertTrue(cacheRepository.isLoggedIn());
    }

    @Test
    public void shouldNotBeLoggedIn() {

        SharedPreferences testPref = RuntimeEnvironment.application.getSharedPreferences("test_pref", Context.MODE_PRIVATE);
        CacheRepository cacheRepository = new CacheRepositoryImpl(testPref);
        cacheRepository.setUsername("username");
        cacheRepository.setPassword("");

        Assert.assertFalse(cacheRepository.isLoggedIn());
    }
}
