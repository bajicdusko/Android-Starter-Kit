package com.bajicdusko.androidrxstarterkit.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bajicdusko.androidrxstarterkit.AndroidStarterKitApplication;
import com.bajicdusko.androidrxstarterkit.AndroidStarterKitDaggerComponent;
import com.bajicdusko.androidrxstarterkit.Injector;

import butterknife.ButterKnife;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 13-Jul-16.
 */
public abstract class BaseActivity extends AppCompatActivity implements Injector {

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
    public AndroidStarterKitDaggerComponent injector() {
        return ((AndroidStarterKitApplication) getApplication()).injector();
    }
}
