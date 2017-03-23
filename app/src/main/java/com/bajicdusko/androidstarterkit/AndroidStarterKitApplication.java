package com.bajicdusko.androidstarterkit;

import android.app.Application;

import com.bajicdusko.androidstarterkit.di.activity.ActivityComponent;
import com.bajicdusko.androidstarterkit.di.activity.ActivityModule;
import com.bajicdusko.androidstarterkit.di.app.AndroidModule;
import com.bajicdusko.androidstarterkit.di.app.AndroidStarterKitComponent;
import com.bajicdusko.androidstarterkit.di.app.AndroidStarterKitModule;
import com.bajicdusko.androidstarterkit.di.app.DaggerAndroidStarterKitComponent;
import com.bajicdusko.androidstarterkit.ui.BaseActivity;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

public class AndroidStarterKitApplication extends Application {


    private AndroidStarterKitComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAndroidStarterKitComponent.builder()
                .androidStarterKitModule(new AndroidStarterKitModule(this))
                .androidModule(new AndroidModule(this))
                .build();
    }

    public ActivityComponent getActivityComponent(BaseActivity baseActivity) {
        return component.activityComponentBuilder().activityModule(new ActivityModule(baseActivity)).build();
    }
}
