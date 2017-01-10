package com.bajicdusko.androidstarterkit.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bajicdusko.androidstarterkit.AndroidStarterKitApplication;
import com.bajicdusko.androidstarterkit.AndroidStarterKitDaggerComponent;
import com.bajicdusko.androidstarterkit.Injector;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 13-Jul-16.
 */
public abstract class BaseActivity extends AppCompatActivity implements Injector {

    @Inject
    Bus bus;

    private final int NO_LAYOUT = -1;

    protected int getContentLayoutId() {
        return NO_LAYOUT;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injector().inject(this);
        if (getContentLayoutId() != NO_LAYOUT) {
            setContentView(getContentLayoutId());
            ButterKnife.bind(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        bus.unregister(this);
    }

    @Override
    public AndroidStarterKitDaggerComponent injector() {
        return ((AndroidStarterKitApplication) getApplication()).injector();
    }
}
