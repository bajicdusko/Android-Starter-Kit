package com.bajicdusko.androidboilerplate;

import android.app.Application;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 15-Aug-16.
 */

public class BoilerplateApplication extends Application {

    BoilerplateDaggerComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerBoilerplateDaggerComponent.builder().boilerplateModule(new BoilerplateModule(this)).build();
    }

    public BoilerplateDaggerComponent injector() {
        return component;
    }
}
