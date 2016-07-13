package com.bajicdusko.androidboilerplate.ui.activity;

import android.widget.TextView;

import com.bajicdusko.androidboilerplate.R;
import com.bajicdusko.androidboilerplate.ui.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.activity_main_tv_hello)
    TextView tvHello;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }
}
