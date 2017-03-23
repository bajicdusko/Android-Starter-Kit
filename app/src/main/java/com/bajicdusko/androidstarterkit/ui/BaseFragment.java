package com.bajicdusko.androidstarterkit.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bajicdusko.androidstarterkit.di.activity.ActivityComponent;

import butterknife.ButterKnife;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 23/03/2017.
 */

public abstract class BaseFragment extends Fragment {

    protected abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public ActivityComponent injector() {
        return ((BaseActivity) getContext()).injector();
    }
}
