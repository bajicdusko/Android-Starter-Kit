package com.bajicdusko.androidstarterkit.di.activity;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.bajicdusko.androidstarterkit.ui.BaseActivity;
import com.bajicdusko.androidstarterkit.ui.fragment.manager.FragmentManagerHandler;
import com.bajicdusko.data.Constants;
import com.bajicdusko.presenter.PresenterModule;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

@ActivityScope
@Module(includes = {PresenterModule.class})
public class ActivityModule {

    private final BaseActivity baseActivity;

    public ActivityModule(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    @Provides
    @Named(Constants.ACTIVITY_CONTEXT)
    public Context provideActivityContext() {
        return baseActivity;
    }

    @Provides
    public FragmentManager provideFragmentManager() {
        return baseActivity.getSupportFragmentManager();
    }

    @Provides
    public FragmentManagerHandler provideStarterKitFragmentManager(FragmentManager fragmentManager) {
        return new FragmentManagerHandler(fragmentManager);
    }
}
