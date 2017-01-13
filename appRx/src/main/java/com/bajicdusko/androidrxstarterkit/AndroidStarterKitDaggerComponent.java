package com.bajicdusko.androidrxstarterkit;

import com.bajicdusko.androidrxstarterkit.core.CoreModule;
import com.bajicdusko.androidrxstarterkit.ui.BaseActivity;
import com.bajicdusko.androidrxstarterkit.ui.FragmentUtility;
import com.bajicdusko.androidrxstarterkit.ui.activity.MainActivity;
import com.bajicdusko.androidrxstarterkit.ui.fragment.HomeFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 18-Jul-16.
 */

@Singleton
@Component(modules = {
        AndroidStarterKitModule.class,
        CoreModule.class
})
public interface AndroidStarterKitDaggerComponent {

    void inject(BaseActivity activity);

    void inject(MainActivity activity);

    void inject(HomeFragment fragment);

    void inject(FragmentUtility fragmentUtility);
}
