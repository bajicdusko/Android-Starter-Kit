package com.bajicdusko.androidstarterkit.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.bajicdusko.androidstarterkit.R;
import com.bajicdusko.androidstarterkit.ui.fragment.QuestionFragment;
import com.bajicdusko.androidstarterkit.ui.fragment.StarterKitFragmentManager;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public class HomeActivity extends BaseActivity {

    @Inject
    StarterKitFragmentManager starterKitFragmentManager;

    @BindView(R.id.activity_home_fl_container)
    FrameLayout flContainer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injector().inject(this);
        starterKitFragmentManager.setFragmentContainerId(flContainer);
        starterKitFragmentManager.replaceFragment(QuestionFragment.newInstance());
    }
}
