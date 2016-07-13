package com.bajicdusko.androidboilerplate.ui.fragment;

import android.widget.TextView;

import com.bajicdusko.androidboilerplate.R;
import com.bajicdusko.androidboilerplate.ui.BaseFragment;

import butterknife.BindView;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 13-Jul-16.
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.fragment_home_tv_hello)
    TextView tvHello;

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_home;
    }
}
