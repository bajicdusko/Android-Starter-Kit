package com.bajicdusko.androidrxstarterkit.ui.activity;

import android.os.Bundle;

import com.bajicdusko.androidrxstarterkit.R;
import com.bajicdusko.androidrxstarterkit.core.cache.CacheManager;
import com.bajicdusko.androidrxstarterkit.ui.BaseActivity;
import com.bajicdusko.androidrxstarterkit.ui.FragmentUtility;
import com.bajicdusko.androidrxstarterkit.ui.fragment.HomeFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    CacheManager cacheManager;

    FragmentUtility fragmentUtility;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injector().inject(this);
        fragmentUtility = new FragmentUtility(this, R.id.activity_main_fl_fragment_container, cacheManager);
        fragmentUtility.addFragment(HomeFragment.newInstance());
    }
}
