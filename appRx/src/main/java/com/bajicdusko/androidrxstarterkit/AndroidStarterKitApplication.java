package com.bajicdusko.androidrxstarterkit;

import android.app.Application;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class AndroidStarterKitApplication extends Application {

    AndroidStarterKitDaggerComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAndroidStarterKitDaggerComponent.builder().androidStarterKitModule(new AndroidStarterKitModule(this)).build();
    }

    public AndroidStarterKitDaggerComponent injector() {
        return component;
    }
}
