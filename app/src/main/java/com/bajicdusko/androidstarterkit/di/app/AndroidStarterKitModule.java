package com.bajicdusko.androidstarterkit.di.app;

import com.bajicdusko.androidstarterkit.AndroidStarterKitApplication;
import com.bajicdusko.androidstarterkit.di.activity.ActivityComponent;

import javax.inject.Singleton;

import dagger.Module;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

@Singleton
@Module(subcomponents = {ActivityComponent.class})
public class AndroidStarterKitModule {

    private final AndroidStarterKitApplication application;

    public AndroidStarterKitModule(AndroidStarterKitApplication application) {
        this.application = application;
    }
}
