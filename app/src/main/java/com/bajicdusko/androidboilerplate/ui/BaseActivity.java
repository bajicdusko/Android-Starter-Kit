package com.bajicdusko.androidboilerplate.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 13-Jul-16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private final int NO_LAYOUT = -1;

    protected int getContentLayoutId(){
        return NO_LAYOUT;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getContentLayoutId() != NO_LAYOUT){
            setContentView(getContentLayoutId());
            ButterKnife.bind(this);
        }
    }
}
