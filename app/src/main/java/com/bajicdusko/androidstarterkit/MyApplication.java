package com.bajicdusko.androidstarterkit;

import android.app.Application;

import com.bajicdusko.androidstarterkit.di.activity.ActivityComponent;
import com.bajicdusko.androidstarterkit.di.activity.ActivityModule;
import com.bajicdusko.androidstarterkit.di.app.AndroidModule;
import com.bajicdusko.androidstarterkit.di.app.ApplicationComponent;
import com.bajicdusko.androidstarterkit.di.app.ApplicationModule;
import com.bajicdusko.androidstarterkit.di.app.DaggerApplicationComponent;
import com.bajicdusko.androidstarterkit.model.Owner;
import com.bajicdusko.androidstarterkit.model.SOQuestion;
import com.bajicdusko.androidstarterkit.ui.BaseActivity;
import com.squareup.leakcanary.LeakCanary;

import org.parceler.Parcel;
import org.parceler.ParcelClass;
import org.parceler.ParcelClasses;

import timber.log.Timber;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

@ParcelClasses(value = {
        @ParcelClass(value = Owner.class, annotation = @Parcel(Parcel.Serialization.BEAN)),
        @ParcelClass(value = SOQuestion.class, annotation = @Parcel(analyze = Owner.class, value = Parcel.Serialization.BEAN))}
)
public class MyApplication extends Application {


    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .androidModule(new AndroidModule(this))
                .build();
    }

    public ActivityComponent getActivityComponent(BaseActivity baseActivity) {
        return component.activityComponentBuilder().activityModule(new ActivityModule(baseActivity)).build();
    }
}
