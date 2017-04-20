package com.bajicdusko.androidstarterkit.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bajicdusko.androidstarterkit.MyApplication;
import com.bajicdusko.androidstarterkit.di.activity.ActivityComponent;

import butterknife.ButterKnife;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    public ActivityComponent injector() {
        return ((MyApplication) getApplicationContext()).getActivityComponent(this);
    }
}
