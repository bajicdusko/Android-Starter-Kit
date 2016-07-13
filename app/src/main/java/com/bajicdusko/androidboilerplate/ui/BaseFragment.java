package com.bajicdusko.androidboilerplate.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 13-Jul-16.
 */
public abstract class BaseFragment extends Fragment {

    private final int NO_LAYOUT = -1;

    protected int getContentLayout(){
        return NO_LAYOUT;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(getContentLayout() == NO_LAYOUT) {
            return super.onCreateView(inflater, container, savedInstanceState);
        } else {
            View view = inflater.inflate(getContentLayout(), container, false);
            ButterKnife.bind(this, view);
            return view;
        }
    }
}
