package com.bajicdusko.androidstarterkit.di.activity;

import dagger.Subcomponent;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        Builder activityModule(ActivityModule activityModule);

        ActivityComponent build();
    }
}
