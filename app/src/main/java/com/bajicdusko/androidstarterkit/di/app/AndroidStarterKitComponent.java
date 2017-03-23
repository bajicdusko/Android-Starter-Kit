package com.bajicdusko.androidstarterkit.di.app;

import com.bajicdusko.androidstarterkit.di.activity.ActivityComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

@Singleton
@Component(modules = {AndroidStarterKitModule.class, AndroidModule.class})
public interface AndroidStarterKitComponent {
    ActivityComponent.Builder activityComponentBuilder();
}
