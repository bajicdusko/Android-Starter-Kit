package com.bajicdusko.androidstarterkit.ui.activity;

import android.os.Bundle;

import com.bajicdusko.androidstarterkit.R;
import com.bajicdusko.androidstarterkit.core.cache.CacheManager;
import com.bajicdusko.androidstarterkit.ui.BaseActivity;
import com.bajicdusko.androidstarterkit.ui.FragmentUtility;
import com.bajicdusko.androidstarterkit.ui.fragment.HomeFragment;

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
