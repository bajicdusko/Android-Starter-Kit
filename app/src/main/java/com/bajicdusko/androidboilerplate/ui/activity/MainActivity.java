package com.bajicdusko.androidboilerplate.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.bajicdusko.androidboilerplate.R;
import com.bajicdusko.androidboilerplate.core.cache.CacheManager;
import com.bajicdusko.androidboilerplate.ui.BaseActivity;
import com.bajicdusko.androidboilerplate.ui.FragmentUtility;
import com.bajicdusko.androidboilerplate.ui.fragment.HomeFragment;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.activity_main_tv_hello)
    TextView tvHello;
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
