package com.bajicdusko.androidboilerplate;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 18-Jul-16.
 */

@Module(includes = {
        AndroidModule.class
})
public class BoilerplateModule {

    private Context context;

    public BoilerplateModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return context;
    }
}
